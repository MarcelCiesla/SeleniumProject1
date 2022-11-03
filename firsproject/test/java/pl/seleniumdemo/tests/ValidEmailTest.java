package test.java.pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ValidEmailTest extends BaseTest {

    @Test
    public void email() {

        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();

        driver.findElement(By.name("firstname")).sendKeys("Marcel");
        driver.findElement(By.name("lastname")).sendKeys("Cieslozord");
        driver.findElement(By.name("phone")).sendKeys("666222111");
        driver.findElement(By.name("email")).sendKeys("lele.pl");
        driver.findElement(By.name("password")).sendKeys("lelelelel");
        driver.findElement(By.name("confirmpassword")).sendKeys("lelelelel");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        List<String> errors = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).stream()
                        .map(WebElement::getText)
                                .collect(Collectors.toList());

        Assert.assertTrue(errors.contains("The Email field must contain a valid email address."));

    }
}
