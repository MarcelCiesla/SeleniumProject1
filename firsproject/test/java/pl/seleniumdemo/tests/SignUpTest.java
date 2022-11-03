package test.java.pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test
    public void signUp()  {

        int randomNumber = (int) (Math.random()*1000);
        String email = "tester" + randomNumber + "@rak.pl";
        String lastName = "Cieslozord";
        driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();

        driver.findElement(By.name("firstname")).sendKeys("Marcel");
        driver.findElement(By.name("lastname")).sendKeys("Cieslozord");
        driver.findElement(By.name("phone")).sendKeys("666222111");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("lelelelel");
        driver.findElement(By.name("confirmpassword")).sendKeys("lelelelel");

        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();
        WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));

        Assert.assertTrue(heading.getText().contains(lastName));
        Assert.assertEquals(heading.getText(),"Hi, Marcel Cieslozord");



    }
}