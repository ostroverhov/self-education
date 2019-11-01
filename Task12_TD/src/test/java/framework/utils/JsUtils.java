package framework.utils;

import aquality.selenium.browser.BrowserManager;
import org.openqa.selenium.JavascriptExecutor;
import project.projectutils.JsScripts;

public class JsUtils {

    private static JavascriptExecutor js = (JavascriptExecutor) BrowserManager.getBrowser().getDriver();

    public static void closePopUp() {
        js.executeScript(JsScripts.SCRIPT);
    }

//    public static void executeScript(String script) {
//        js.executeScript(script);
//    }
}
