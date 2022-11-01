package pl.seleniumdemo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.ResultsPage;

import java.util.List;
import java.util.stream.Collectors;

public class HotelSearchTest extends BaseTest {

    @Test
    public void searchHotel()  {

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.setCity("Dubai");
        hotelSearchPage.setDates("03/11/2022", "23/11/2022");
        hotelSearchPage.setTravellers();
        hotelSearchPage.performSearch();

        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();

        // Tu przyklad bez PageObjectu

       /* driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Dubai");
        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();
        driver.findElement(By.name("checkin")).sendKeys("02/11/2022");
        driver.findElement(By.name("checkout")).sendKeys("05/11/2022");

        //korzystanie z kalendarza
        driver.findElement(By.name("checkin")).findElement(By.xpath("//td[@class='day ' and text()='30']")).click();
        driver.findElement(By.name("checkout")).findElement(By.xpath("//td[@class='day ' and text()='30']")).click();

        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("adultPlusBtn")).click();
        driver.findElement(By.id("childPlusBtn")).click();

        driver.findElement(By.xpath("//button[text()=' Search']")).click();

*/
       /* List<String> hotelNames = driver.findElements(By.xpath("//h4[contains(@class,'list_title')]//b")).stream()
                                                                                            .map(el -> el.getAttribute("textContent"))
                                                                                            .collect(Collectors.toList());
        System.out.println(hotelNames.size());
        hotelNames.forEach(el -> System.out.println(el));
        hotelNames.forEach(System.out::println);*/

        Assert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));

    }
}