package framework.base

import framework.browser.Browser
import framework.logger.Logger
import framework.utils.Reader
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

abstract class BaseTest {
    protected abstract void runTest()

    @BeforeMethod
    before() {
        Logger.step("Start test")
        Browser.setImplicitlyWait(Reader.getParameter("timeout"))
        Browser.setMaxSizeWindow()
        Browser.setUrl(Reader.getParameter("URL"))
    }

    @AfterMethod
    after() {
        Browser.closeBrowser()
    }
}
