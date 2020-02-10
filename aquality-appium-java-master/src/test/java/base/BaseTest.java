package base;

import aquality.appium.application.ApplicationManager;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private AndroidDriver<?> driver;

    @BeforeClass
    public void setUp() {
        driver = (AndroidDriver<?>) ApplicationManager.getApplication().getDriver();
    }

    @AfterClass
    public void tearDown() {
        ApplicationManager.getApplication().quit();
    }
}