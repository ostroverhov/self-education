package framework.browser

import framework.utils.Reader
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxOptions

class BrowserSettings {
    static ChromeOptions chromeSettings() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>()
        chromePrefs.put("profile.default_content_settings.popups", 0)
        chromePrefs.put("safebrowsing.enabled", "true")
        chromePrefs.put("intl.accept_languages", Reader.getParameter("locale"))
        ChromeOptions options = new ChromeOptions()
        options.setExperimentalOption("prefs", chromePrefs)
    }

    static FirefoxOptions firefoxSettings() {
        FirefoxOptions firefoxOptions = new FirefoxOptions()
        firefoxOptions.addPreference("browser.download.folderList", 2)
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream, application/x-debian-package")
        firefoxOptions.addPreference("intl.accept_languages", Reader.getParameter("locale"))
    }
}
