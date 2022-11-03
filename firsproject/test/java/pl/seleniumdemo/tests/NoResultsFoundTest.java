package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;
import pl.seleniumdemo.tests.BaseTest;

public class NoResultsFoundTest extends BaseTest {

    @Test
    public void Noresultsfound() {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setDates("02/11/2022","05/11/2022");
        hotelSearchPage.setTravellers(0,1);
        hotelSearchPage.performSearch();


        // tu bez PageObjectu
        /*driver.findElement(By.name("checkin")).sendKeys("02/11/2022");
        driver.findElement(By.name("checkout")).sendKeys("05/11/2022");
        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("childPlusBtn")).click();
        driver.findElement(By.xpath("//button[text()=' Search']")).click();

        WebElement nofound = driver.findElement(By.xpath("//h2[text()= 'No Results Found']"));
        *//*Assert.assertEquals(nofound.getText(), "No Results Found");*/

        ResultsPage resultsPage = new ResultsPage(driver);

        Assert.assertTrue((resultsPage.resultHeading.isDisplayed()));
        Assert.assertEquals(resultsPage.getHeadingText(),"No Results Found");



    }
}
