package test.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumHelper {

    // to sie uzywa zamiat tego implicityWait

    public static void waitForElementToExist(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10l));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10l));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForNotEmptyListy(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10l));
        wait.until(browser -> browser.findElements(locator).size()>0 );
    }
}
