package pages;

import objects.Credentials;
import objects.MovieRowData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.Properties;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PageActions {

    private static String USER_NAME_XPATH = ".//input[@name = 'username']";
    private static String USER_PASS_XPATH = ".//input[@name = 'password']";
    private static String LOGIN_BUTTON_XPATH = ".//div[@id = 'main']//input[@type = 'submit']";
    private static String RESULTS_TABLE_XPATH = ".//table[contains(@class, 'peer')]//tr[position() > 1]";
    private WebDriver driver;
    private Paginator paginator;

    private PageActions(WebDriver driver) {
        this.driver = driver;
        this.paginator = new Paginator(driver);
    }

    static PageActions navigateTo(WebDriver driver) {
        driver.navigate().to(Properties.getProperty("host"));
        return new PageActions(driver);
    }

    void login(Credentials creds) {
        driver.findElement(By.xpath(USER_NAME_XPATH)).sendKeys(creds.getUsername());
        driver.findElement(By.xpath(USER_PASS_XPATH)).sendKeys(creds.getPassword());
        driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
    }

    List<MovieRowData> getSearchResult(String searchRequest) {
        List<MovieRowData> results = new ArrayList<>();
        checkSpamPage();
        driver.navigate().to(getSearchUrl(searchRequest));
        while (paginator.isNextDiaplayed()) {
            results.addAll(getSearchResultPage());
            paginator.nextPage();
        }
        results.addAll(getSearchResultPage());
        return results;
    }

    private List<MovieRowData> getSearchResultPage() {
        return driver.findElements(By.xpath(RESULTS_TABLE_XPATH))
                .stream().map(MovieRowData::createMovieRowData).collect(Collectors.toList());
    }

    private void checkSpamPage() {
        if (driver.getWindowHandles().size() > 1) {
            ArrayList<String> tabsList = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabsList.get(0));
        }
    }

    private String getSearchUrl(final String searchRequest) {
        return driver.getCurrentUrl().replace("userdetails","browse") + searchRequest;
    }
}
