package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static util.BrowserManager.createChromeConfig;


public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        setup();
        return driver;
    }

    private static void setup() {
        driver = new ChromeDriver(createChromeConfig());
        driver = new EventFiringWebDriver(driver).register(new WebEventListener());

    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
