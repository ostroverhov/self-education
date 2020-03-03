package base

import framework.application.App
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass

open class BaseTest {

    @BeforeClass
    open fun setUp() {
        App.setUpDriver()
    }

    @AfterClass
    open fun tearDown() {
        App.quit()
    }
}