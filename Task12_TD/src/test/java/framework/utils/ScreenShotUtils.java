package framework.utils;

import aquality.selenium.logger.Logger;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import project.models.UploadScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

public class ScreenShotUtils {

    private static final Logger logger = Logger.getInstance();

    public static void makeScreenshot(WebDriver driver, String nameScreenshot) {
        logger.info("Make screenshot " + nameScreenshot);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(nameScreenshot));
        } catch (IOException e) {
            logger.warn("Screenshot don't make");
        }
    }

    public static UploadScreenshot uploadImage(String nameImage) {
        logger.info("Upload image " + nameImage);
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", ReaderUtils.getParameter("cloudName"),
                "api_key", ReaderUtils.getParameter("apiKey"),
                "api_secret", ReaderUtils.getParameter("apiSecret")));
        File file = new File(nameImage);
        Map result = null;
        try {
            result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            logger.warn("Image don't upload");
        }
        return new Gson().fromJson(String.valueOf(new JSONObject(result)), UploadScreenshot.class);
    }

    public static String screenShotToString(String pathToScreenshot) {
        String screenshotCode = null;
        try {
            screenshotCode = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(new File(pathToScreenshot)));
        } catch (IOException e) {
            logger.warn("Can't convert screenshot to string");
        }
        return screenshotCode;
    }
}
