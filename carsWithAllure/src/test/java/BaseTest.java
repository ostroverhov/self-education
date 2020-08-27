import framework.browser.BrowserFactory;
import framework.utils.AllureUtils;
import framework.utils.MyLogger;
import framework.utils.Reader;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Link;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class BaseTest {
    public static final String URL = Reader.getParametr("URL");

    @BeforeMethod
    public void setUp() {
        MyLogger.step("Start test");
        BrowserFactory.setImplicityWait(Integer.parseInt(Reader.getParametr("timeout")));
        BrowserFactory.setMaxSizeWindow();
        BrowserFactory.setUrl(URL);
        HashMap<String, String> allureProperties = new HashMap<>();
        allureProperties.put("Browser", System.getProperty("browser"));
        AllureUtils.createEnvironmentProperties(allureProperties);
    }

    @AfterMethod
    public void tearDown() {
        MyLogger.step("Finish test");
        makeScreenshot();
        BrowserFactory.closeBrowser();
    }

    @Link
    private void addLink(){
        Allure.link(Reader.getParametr("URL"));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return BrowserFactory.makeScreenShot();
    }
}