package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.model.User;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.SignUpPage;
import pl.seleniumdemo.tests.BaseTest;

public class SignUpTest extends BaseTest {

    @Test
    public void signUp() {
        String lastName = "Cieslozord";
        int randomNumber = (int) (Math.random() * 1000);

        /*HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();*/

        //SignUpPage signUpPage = new SignUpPage(driver)

        LoggedUserPage loggedUserPage = new HotelSearchPage(driver)
                .openSignUpForm()
                .setFirstName("Marcel")
                .setLastName(lastName)
                .setPhone("666222111")
                .setEmail("tester" + randomNumber + "@rak.pl")
                .setPassword("lelele")
                .setConfirmPassword("lelele")
                .clickSignUp();

        //LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Marcel Cieslozord");


        // Bez PageObjectów
        /*driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
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
        Assert.assertEquals(heading.getText(),"Hi, Marcel Cieslozord");*/


    }

    // Inny sposób zapisu (krótszy w kodzie)
   /* @Test
    public void signUpTest2() {
        //String lastName = "Cieslozord";
        int randomNumber = (int) (Math.random() * 1000);
        String email = "tester" + randomNumber + "@rak.pl";

        User user = new User();
        user.setFirstName("Marcel");
        user.setLastName("Cieslozord");
        user.setPhone("66666666");
        user.setEmail(email);
        user.setPassword("lelele");


        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver);
       // signUpPage.fillSignUpForm("Marcel", lastName, "666222444", email, "lelele");
        signUpPage.fillSignUpForm2(user);

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertTrue(loggedUserPage.getHeadingText().contains(user.getLastName()));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Marcel Cieslozord");
    }*/
}