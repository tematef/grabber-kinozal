package util;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

class BrowserManager {

    static ChromeOptions createChromeConfig() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--blink-settings=imagesEnabled=false");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("-disable-cache");
        options.addArguments("--disable-javascript");
//        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("profile.default_content_settings.popups", 0);
//        prefs.put("download.default_directory", System.getProperty("java.io.tmpdir"));
//        options.setExperimentalOption("prefs", prefs);
//        caps.setCapability("chrome.switches", Arrays.asList("--disable-javascript"));

        return options;
    }

    static String getChromeDriverPath() {
        String path = System.getProperty("user.dir") + File.separator
                + Properties.getProperty("driver_project_path") + File.separator;
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return path + "238_win_chromedriver.exe";
        }
        if (os.contains("mac")) {
            return path + "238_mac_chromedriver";
        }
        if (os.contains("linux")) {
            return path + "238_linux_chromedriver";
        }
        throw new InvalidArgumentException("OS is not on the list");
    }
}
