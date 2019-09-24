package framework.utils;

import app.models.ModelMessage;
import com.sun.mail.imap.IMAPFolder;
import framework.browser.BrowserFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class EmailUtils {

    private static IMAPFolder folder;
    private static Store store;

    public static ModelMessage getLastEmail(String userName, String password) {
        ModelMessage modelMessage = null;
        try {
            Message[] messages = getMassages(userName, password);
            for (Message msg : messages) {
                modelMessage = new ModelMessage(msg.getSubject(), getText(msg));
            }
            closeFolderStore();
        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        }
        return modelMessage;
    }

    private static boolean isPresentEmail(String userName, String password) {
        return getMassages(userName, password).length > 0;
    }

    public static void waitMessageFromEmail(String userName, String password) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getInstance(), Integer.parseInt(Reader.getParametr("timeout")));
        wait.until(webDriver -> isPresentEmail(userName, password));
    }

    public static void deleteEmail(String userName, String password) {
        try {
            Message[] messages = getMassages(userName, password);
            Flags deleted = new Flags(Flags.Flag.DELETED);
            folder.setFlags(messages, deleted, true);
            closeFolderStore();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static void closeFolderStore() throws MessagingException {
        if (folder.isOpen()) {
            folder.close(true);
        }
        if (store != null) {
            store.close();
        }
    }

    private static Session getSession(String userName, String password) {
        Properties properties = new Properties();
        properties.put("mail.imap.host", "imap.gmail.com");
        properties.put("mail.imap.port", "993");
        properties.setProperty("mail.imap.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port", String.valueOf(993));
        return Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });
    }

    private static Message[] getMassages(String userName, String password) {
        Message[] messages = null;
        try {
            store = getSession(userName, password).getStore("imaps");
            store.connect("imap.gmail.com", userName, password);
            folder = (IMAPFolder) store.getFolder("inbox");
            if (!folder.isOpen()) {
                folder.open(Folder.READ_WRITE);
            }
            messages = folder.getMessages();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return messages;
    }

    private static String getText(Part part) throws MessagingException, IOException {
        if (part.isMimeType("text/*")) {
            String partContent = (String) part.getContent();
            part.isMimeType("text/html");
            return partContent;
        }
        if (part.isMimeType("multipart/alternative")) {
            Multipart multipart = (Multipart) part.getContent();
            String text = null;
            for (int i = 0; i < multipart.getCount(); i++) {
                Part bodyPart = multipart.getBodyPart(i);
                if (bodyPart.isMimeType("text/plain")) {
                    if (text == null) {
                        text = getText(bodyPart);
                    }
                } else if (bodyPart.isMimeType("text/html")) {
                    String messageContent = getText(bodyPart);
                    if (messageContent != null) {
                        return messageContent;
                    }
                } else {
                    return getText(bodyPart);
                }
            }
            return text;
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            for (int i = 0; i < multipart.getCount(); i++) {
                String messageContent = getText(multipart.getBodyPart(i));
                if (messageContent != null) {
                    return messageContent;
                }
            }
        }
        return null;
    }
}
