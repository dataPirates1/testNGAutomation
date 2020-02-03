package testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumintro.SmartBear1;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearDeleteOrder {
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

    public void deleteMarkSmith() {


       // driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBear1.loginToSmartBear(driver);
        WebElement markSmithCheckBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_orderGrid_ctl03_OrderSelector']"));
        markSmithCheckBox.click();

        WebElement deleteSelected = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$btnDelete']"));
        deleteSelected.click();

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        for(WebElement name : allNames) {
            System.out.println(name.getText());
            Assert.assertFalse(name.getText().equals("Mark Smith"), "The name is in the list. Test FAILED!!!");
        }

          }


    @Test
    public void editOrderTest () {
       // driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBear1.loginToSmartBear(driver);


    }

}
