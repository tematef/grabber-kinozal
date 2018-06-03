package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class Paginator {

    private static String NEXT_PAGE_XPATH = ".//a[@rel = 'next']";
    private WebDriver driver;

    Paginator(WebDriver driver) {
        this.driver = driver;
    }

    void nextPage() {
        driver.findElement(By.xpath(NEXT_PAGE_XPATH)).click();
    }

    boolean isNextDiaplayed() {
        return driver.findElements(By.xpath(NEXT_PAGE_XPATH)).size() > 0;
    }
}
