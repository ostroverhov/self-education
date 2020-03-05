package framework.waitings

import aquality.selenium.logger.Logger
import framework.application.App
import framework.utils.getParameter
import io.appium.java_client.AppiumFluentWait
import java.time.Duration

val logger: Logger = Logger.getInstance()

fun waitFor(
    condition: org.openqa.selenium.support.ui.ExpectedCondition<Boolean>,
    message: String,
    timeOutInSeconds: Long = getParameter("timeout")!!.toLong(),
    pollingIntervalInMilliseconds: Long = 500
): Boolean? {
    logger.info("Waiting element")
    val wait = AppiumFluentWait(App.getDriver())
    wait.withTimeout(Duration.ofSeconds(timeOutInSeconds))
    wait.pollingEvery(Duration.ofMillis(pollingIntervalInMilliseconds))
    wait.withMessage(message)
    return wait.until(condition)
}