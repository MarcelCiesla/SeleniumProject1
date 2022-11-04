package test.java.pl.seleniumdemo.tests;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.utils.DriverFactory;


import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10l));
        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
