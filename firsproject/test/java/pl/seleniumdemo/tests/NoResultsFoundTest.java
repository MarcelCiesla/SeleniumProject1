package test.java.pl.seleniumdemo.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pl.seleniumdemo.pages.HotelSearchPage;
import test.java.pl.seleniumdemo.pages.ResultsPage;


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
