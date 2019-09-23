package app.projectUtils;

import app.models.ModelMessage;
import com.sun.mail.imap.IMAPFolder;
import framework.browser.BrowserFactory;
import framework.utils.Reader;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class EmailUtils {

    public static ModelMessage searchEmail(String userName, String password) {
        IMAPFolder folder;
        Store store;
        ModelMessage modelMessage = null;
        try {
            Session session = getSession(userName, password);
            store = session.getStore("imaps");
            store.connect("imap.gmail.com", userName, password);
            folder = (IMAPFolder) store.getFolder("inbox");
            if (!folder.isOpen())
                folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();
            for (Message msg : messages) {
                modelMessage = new ModelMessage(msg.getSubject(), getText(msg));
            }
            if (folder != null && folder.isOpen()) {
                folder.close(true);
            }
            if (store != null) {
                store.close();
            }
        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        }
        return modelMessage;
    }

    public static void waitMessage(String userName, String password) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getInstance(), Integer.parseInt(Reader.getParametr("timeout")));
        wait.until(webDriver -> searchEmail(userName, password));
    }

    public static void deleteEmail(String userName, String password) {
        IMAPFolder folder;
        Store store;
        try {
            Session session = getSession(userName, password);
            store = session.getStore("imaps");
            store.connect("imap.gmail.com", userName, password);
            folder = (IMAPFolder) store.getFolder("inbox");
            if (!folder.isOpen())
                folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();
            Flags deleted = new Flags(Flags.Flag.DELETED);
            folder.setFlags(messages, deleted, true);
            if (folder != null && folder.isOpen()) {
                folder.close(true);
            }
            if (store != null) {
                store.close();
            }
        } catch (MessagingException e) {
            e.printStackTrace();
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

    private static String getText(Part p) throws MessagingException, IOException {
        if (p.isMimeType("text/*")) {
            String s = (String) p.getContent();
            p.isMimeType("text/html");
            return s;
        }

        if (p.isMimeType("multipart/alternative")) {
            Multipart mp = (Multipart) p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getText(bp);
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(bp);
                    if (s != null)
                        return s;
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }
        return null;
    }
}
