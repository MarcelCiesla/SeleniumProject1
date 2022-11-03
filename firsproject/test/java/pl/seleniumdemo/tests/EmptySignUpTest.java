package test.java.pl.seleniumdemo.tests;

import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;
import test.java.pl.seleniumdemo.pages.HotelSearchPage;
import test.java.pl.seleniumdemo.pages.SignUpPage;

import java.util.List;
import java.util.stream.Collectors;

public class EmptySignUpTest extends BaseTest {

    @Test
    public void Empty() {
        //HotelSearchPage hotelSearchPage = new HotelSearchPage(driver)
        SignUpPage signUpPage = new HotelSearchPage(driver)
                .openSignUpForm();
        //SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSignUp();

        List<String> errors = signUpPage.getErrors();

        // Bez PageObjectów
        /*driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']")).get(1).click();
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        List<String> errors = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).stream()
                        .map(WebElement::getText)
                         .collect(Collectors.toList());*/

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("The Email field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The First name field is required."));
        softAssert.assertTrue(errors.contains("The Last Name field is required."));
        softAssert.assertAll();


    }


}
