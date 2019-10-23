package framework.base;

import aquality.selenium.browser.Browser;
import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import framework.configurations.Configuration;
import framework.enums.TestStatus;
import framework.utils.ScreenshotUtils;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;
import project.models.UploadScreenshot;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected final Logger logger = Logger.getInstance();
    private static final String resultScreenshotName = "resultScreenshot.png";
    private static final String downloadScreenshotName = "downloadScreenshot.png";

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
        getBrowser().goTo(Configuration.getCurrentEnvironment().getStartUrl());
        getBrowser().setWindowSize(1920, 1080);
    }

    /**
     * Close browser and made screenshot after each test Class
     */
    @AfterMethod
    public void afterMethod(ITestContext testContext, ITestResult testResult) throws Exception {
        TestStatus testStatus;
        if (testResult.getStatus() == TestResult.SUCCESS) {
            testStatus = TestStatus.PASSED;
        } else {
            testStatus = TestStatus.FAILED;
        }
        makeScreenshot();

        ScreenshotUtils.makeScreenshot(getBrowser().getDriver(), resultScreenshotName);
        UploadScreenshot uploadScreenshot = ScreenshotUtils.uploadImage(resultScreenshotName);
        ScreenshotUtils.downloadImage(uploadScreenshot.getUrl(), downloadScreenshotName);
        Assert.assertTrue(ScreenshotUtils.compareImage(resultScreenshotName, downloadScreenshotName), "image not equals");

        logger.info("=== TEST '%1$s' '%2$s' ===", testContext.getName(), testStatus.toString(),
                formatDuration(testResult.getEndMillis() - testResult.getStartMillis()));
        getBrowser().quit();
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

