package app;

import objects.Credentials;
import objects.MovieRowData;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.Login;
import util.DriverFactory;
import util.FileUtil;
import java.io.File;
import java.util.List;

import static objects.enums.DataFiles.GRABBED_DATA_FOLDER;
import static objects.enums.DataFiles.UHD_RELEASE;
import static pages.Login.navigateTo;
import static util.BrowserManager.getChromeDriverPath;

public class TestApp {
    DriverFactory driverFactory = new DriverFactory();

    @Test
    public void test1() {
        String chromePath = getChromeDriverPath();
        System.setProperty("webdriver.chrome.driver", chromePath);
        WebDriver driver = driverFactory.getDriver();

        Login login = navigateTo(driver);
        login.login(Credentials.getCredentials());
        List<MovieRowData> list = login.searchElemnts("&s=&g=0&c=1002&v=7&d=2018&w=0&t=0&f=0");
        list.forEach(item -> System.out.println(item.toString()));
    }

//    @Test
//    public void test1() {
//        String chromePath = getChromeDriverPath();
//        System.setProperty("webdriver.chrome.driver", chromePath);
//        driver = DriverFactory.getDriver();
//        driver.manage().deleteAllCookies();
//
////        WebDriverWait driverWait = new WebDriverWait(driver, 20);
////        driverWait.ignoring(StaleElementReferenceException.class);
//
////        driver.navigate().to("https://kinozal-tv.appspot.com/");
//        driver.findElement(By.xpath(userNameXpath)).sendKeys(user);
//        driver.findElement(By.xpath(userPassXpath)).sendKeys(password);
//        driver.findElement(By.xpath(loginButtonXpath)).click();
//
//        if (driver.getWindowHandles().size() > 1) {
//            ArrayList<String> tabsList = new ArrayList<>(driver.getWindowHandles());
//            driver.switchTo().window(tabsList.get(0));
//        }
//        String baseUrl = driver.getCurrentUrl();
//
//        String searchUrl = baseUrl.replace("userdetails","browse") + "&s=&g=0&c=1002&v=7&d=2018&w=0&t=0&f=0";
//
//
//        driver.navigate().to(searchUrl);
//        List<WebElement> rawList = driver.findElements(By.xpath(".//table[contains(@class, 'peer')]//tr[position() > 1]"));
//        List<MovieRowData> list = rawList.stream().map(MovieRowData::createMovieRowData).collect(Collectors.toList());
//        list.forEach(item -> System.out.println(item.toString()));
//    }

    @After()
    public void close() {
        driverFactory.tearDown();
    }

}
