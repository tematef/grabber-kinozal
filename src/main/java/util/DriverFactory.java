package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static util.BrowserManager.createChromeConfig;
import static util.BrowserManager.getChromeDriverPath;

public class DriverFactory {

    private WebDriver driver;

    public DriverFactory() {
        System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
        driver = new ChromeDriver(createChromeConfig());
        driver = new EventFiringWebDriver(driver).register(new WebEventListener());
        driver.manage().deleteAllCookies();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
