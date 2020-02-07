import framework.browser.BrowserFactory;
import framework.utils.MyLogger;
import framework.utils.Reader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public static final String URL = Reader.getParametr("URL");

    @BeforeMethod
    public void setUp() {
        MyLogger.step("Start test");
        BrowserFactory.setImplicityWait(Integer.parseInt(Reader.getParametr("timeout")));
        BrowserFactory.setMaxSizeWindow();
        BrowserFactory.setUrl(URL);
    }

    @AfterMethod
    public void tearDown() {
        MyLogger.step("Finish test");
        BrowserFactory.closeBrowser();
    }
}
