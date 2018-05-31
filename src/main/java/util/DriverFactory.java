package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static util.BrowserManager.createChromeConfig;


public class DriverFactory {

    private WebDriver driver;

    public WebDriver getDriver() {
        setup();
        return driver;
    }

    private void setup() {
        driver = new ChromeDriver(createChromeConfig());
        driver = new EventFiringWebDriver(driver).register(new WebEventListener());
        driver.manage().deleteAllCookies();
    }

    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
