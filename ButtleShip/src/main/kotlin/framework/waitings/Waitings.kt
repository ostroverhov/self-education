package framework.waitings

import aquality.selenium.logger.Logger
import framework.browser.Browser
import framework.utils.getParameter
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.FluentWait
import java.time.Duration

val logger: Logger = Logger.getInstance()

fun waitFor(
    condition: ExpectedCondition<WebElement>,
    message: String,
    timeOutInSeconds: Long = getParameter("timeout")!!.toLong(),
    pollingIntervalInMilliseconds: Long = 500
): WebElement? {
    logger.info("Waiting element")
    val wait = FluentWait(Browser.getDriver())
    wait.withTimeout(Duration.ofSeconds(timeOutInSeconds))
    wait.pollingEvery(Duration.ofMillis(pollingIntervalInMilliseconds))
    wait.withMessage(message)
    return wait.until(condition)
}