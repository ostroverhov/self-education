package framework.utils;

import aquality.selenium.logger.Logger;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.cloudinary.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import project.models.UploadScreenshot;

import java.awt.*;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;

public class ScreenshotUtils {

    private static final Logger logger = Logger.getInstance();

    public static void makeScreenshot(WebDriver driver, String nameScreenshot) throws IOException {
        logger.info("Make screenshot " + nameScreenshot);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(nameScreenshot));
        } catch (IOException e) {
            throw new IOException("Screenshot don't make");
        }
    }

    public static UploadScreenshot uploadImage(String nameImage) throws IOException {
        logger.info("Upload image " + nameImage);
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", Reader.getParameter("cloudName"),
                "api_key", Reader.getParameter("apiKey"),
                "api_secret", Reader.getParameter("apiSecret")));
        File file = new File(nameImage);
        Map result;
        try {
            result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            throw new IOException("Image don't upload");
        }
        return new Gson().fromJson(String.valueOf(new JSONObject(result)), UploadScreenshot.class);
    }

    public static void downloadImage(String urlStr, String nameDownloadImage) throws IOException {
        logger.info("Download image " + nameDownloadImage);
        URL url;
        try {
            url = new URL(urlStr);
            ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(nameDownloadImage);
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            fileOutputStream.close();
            readableByteChannel.close();
        } catch (IOException e) {
            throw new IOException("Image don't download");
        }
    }

    public static boolean compareImage(String screenshot, String downloadScreenshot) throws Exception {
        logger.info("Compare image " + screenshot + " and " + downloadScreenshot);
        Image image1 = Toolkit.getDefaultToolkit().getImage(screenshot);
        Image image2 = Toolkit.getDefaultToolkit().getImage(downloadScreenshot);
        int[] data1 = null;
        int[] data2 = null;
        try {
            PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
            PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);
            if (grab1.grabPixels()) {
                data1 = (int[]) grab1.getPixels();
            }
            if (grab2.grabPixels()) {
                data2 = (int[]) grab2.getPixels();
            }
        } catch (Exception e1) {
            throw new Exception("Pixels don't grab");
        }
        return java.util.Arrays.equals(data1, data2);
    }
}
