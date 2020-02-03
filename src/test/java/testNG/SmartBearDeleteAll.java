package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumintro.SmartBear1;
import seleniumintro.SmartBear1.*;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearDeleteAll {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        }

        @Test
        public void deleteAll() throws InterruptedException {
        SmartBear1.loginToSmartBear(driver);
        WebElement checkAll = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAll.click();

        List<WebElement> checkBoxes = (List<WebElement>) driver.findElement(By.xpath("/table[@id=‘ctl00_MainContent_orderGrid’]/tbody/tr/td[1]"));

        for (WebElement checkbox: checkBoxes) {
            Thread.sleep(2000);
            Assert.assertTrue(checkbox.isSelected());
        }

        WebElement deleteSelectedButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteSelectedButton.click();

        WebElement emptyOrderListMessage = driver.findElement(By.id("ctl00_MainContent_orderMessage"));

        Assert.assertTrue(emptyOrderListMessage.isDisplayed(), "Delete message is not displayed");
        }





}
