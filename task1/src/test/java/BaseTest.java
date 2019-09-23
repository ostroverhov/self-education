import app.projectUtils.EmailUtils;
import framework.browser.BrowserFactory;
import framework.utils.MyLogger;
import framework.utils.Reader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    public static final String URL = Reader.getParametr("URL");

    @BeforeTest
    @Parameters(value = {"email", "password"})
    public void setUp(String email, String password) {
        MyLogger.step("Start test");
        BrowserFactory.setImplicityWait(Integer.parseInt(Reader.getParametr("timeout")));
        BrowserFactory.setMaxSizeWindow();
        BrowserFactory.setUrl(URL);
        EmailUtils.deleteEmail(email, password);
    }

    @AfterTest
    public void tearDown() {
        MyLogger.step("Finish test");
        BrowserFactory.closeBrowser();
    }
}
