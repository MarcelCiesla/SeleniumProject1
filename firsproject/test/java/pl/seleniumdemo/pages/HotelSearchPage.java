package pl.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelSearchPage {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchHotelSpan;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    private WebElement searchHotelInput;

    @FindBy(xpath = "//span[@class='select2-match' and text()='Dubai']")
    private WebElement hotelMatch;

    @FindBy(name = "checkin")
    private WebElement checkInInput;

    @FindBy(name = "checkout")
    private WebElement checkOutInput;

    @FindBy(id = "travellersInput")
    private WebElement travellersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;

    public HotelSearchPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void setCity(String cityName) {
        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        hotelMatch.click();
    }

    public void setDates(String checkIn, String checkOut) {
        checkInInput.sendKeys(checkIn);
        checkOutInput.sendKeys(checkOut);
    }

    public void setTravellers() {
        travellersInput.click();
        adultPlusBtn.click();
        childPlusBtn.click();
    }

    public void performSearch() {
        searchButton.click();
    }

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

    List<String> hotelNames = driver.findElements(By.xpath("//h4[contains(@class,'list_title')]//b")).stream()
*/
}
