package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPractice {

    WebDriver driver;

    @BeforeClass
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyTitle () {
        driver.get("https://www.google.com/");
        Assert.assertTrue(driver.getTitle().contains("Google"), "Title verification - FAIL");

    }

    @Test
    public void backAndForthNavigation() {
        driver.get("https://www.google.com/");
        WebElement gmail = driver.findElement(By.xpath("//div[.='Gmail']"));
        gmail.click();
        Assert.assertTrue(driver.getTitle().contains("Gmail"), "Gmail title verification - FAIL");
        driver.navigate().back();
        Assert.assertTrue(driver.getTitle().contains("Google"), "Google title verification - FAIL");
        driver.navigate().forward();
        Assert.assertTrue(driver.getTitle().contains("Gmail"), "Gmail title verification - FAIL");

    }

    @AfterClass
    public void close() {
        driver.close();
    }









}
