package base

import framework.browser.Browser
import framework.utils.Logger
import framework.utils.getParameter
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

open class BaseTest {

    private val logger: Logger = Logger()

    @BeforeMethod
    fun setUp() {
        logger.step("Start test")
        Browser.getInstance()
        Browser.setImplicitlyWait(getParameter("timeout"))
        Browser.setMaxSizeWindow()
        Browser.setUrl(getParameter("URL"))
    }

    @AfterMethod
    fun tearDown() {
        logger.step("Finish test")
        Browser.closeBrowser()
    }
}