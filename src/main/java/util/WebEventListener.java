package util;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.Arrays;

class WebEventListener extends AbstractWebDriverEventListener {


    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println(String.format("Navigating to url:%s", url));
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println(String.format("Navigated to url:%s", url));
    }


    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        System.out.println("Refreshing page");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        System.out.println("Refreshed page");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Finding element:" + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found element:" + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicking element:" + element.toString());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked element:" + element.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println(String.format("Setting value '%s' to element: %s", Arrays.toString(keysToSend), element.toString()));
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println(String.format("Set value '%s' to element: %s", Arrays.toString(keysToSend), element.toString()));
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
    }}
