package framework.base;

import aquality.selenium.browser.Browser;
import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected final Logger logger = Logger.getInstance();

    /**
     * To override.
     */
    protected abstract void runTest();

    /**
     * Before Class method
     * Configure environment
     * Make a browser window
     */
    @BeforeMethod
    public void before() throws WebDriverException {
        logger.info("=== PRECONDITIONS ===");
    }

    /**
     * Close browser and made screenshot after each test Class
     */
    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestContext testContext, ITestResult testResult) {
        logger.info("=== TEST '%1$s' '%2$s' ===", testContext.getName(),
                formatDuration(testResult.getEndMillis() - testResult.getStartMillis()));
    }

    private String formatDuration(long milliseconds) {
        long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds - TimeUnit.HOURS.toMillis(hours));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds - TimeUnit.HOURS.toMillis(hours) - TimeUnit.MINUTES.toMillis(minutes));
        return String.format("TEST DURATION WAS %1$sh $2$sm $3$ss", hours, minutes, seconds);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return getBrowser().getScreenshot();
    }

    private Browser getBrowser() {
        return BrowserManager.getBrowser();
    }
}

