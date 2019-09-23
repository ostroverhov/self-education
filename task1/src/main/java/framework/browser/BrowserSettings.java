package framework.browser;

import framework.utils.Reader;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;


public class BrowserSettings {

    public static ChromeOptions chromeSettings() {
        String pathToDownload = Reader.getParametr("path");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "/" + pathToDownload);
        chromePrefs.put("safebrowsing.enabled", "true");
        chromePrefs.put("intl.accept_languages", Reader.getParametr("locale"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        return options;
    }

    public static FirefoxOptions firefoxSettings() {
        String pathToDownload = Reader.getParametr("path");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("browser.download.dir", System.getProperty("user.dir") + "/" + pathToDownload);
        firefoxOptions.addPreference("browser.download.folderList", 2);
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream, application/x-debian-package");
        firefoxOptions.addPreference("intl.accept_languages", Reader.getParametr("locale"));
        return firefoxOptions;
    }
}
