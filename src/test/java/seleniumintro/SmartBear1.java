package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SmartBear1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //type login, password and click

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
//        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
//        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        loginToSmartBear(driver);
        verifyOrder(driver, "Paul Brown");

        //print how many links
        int count = 0;
        List<WebElement> list = driver.findElements(By.xpath("//body//a"));
        count = list.size();
        System.out.println(count);

        //print links
        for (WebElement wb: list) {
            System.out.println(wb.getText());
        }
    }

    public static void loginToSmartBear(WebDriver driver) {
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();
    }


    public static void verifyOrder (WebDriver driver, String name) {
        List <WebElement> list = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));

        for (WebElement name1: list) {
            if (name1.getText().equals(name)) {
                System.out.println("Name exists in the list - PASS");
                return;
            }
        }
        System.out.println("Name does not exist in the list - FAIL");

    }

    public static void printNamesAndCities (WebDriver driver) {
        List <WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        List <WebElement> allCities = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[7]"));



        for (int i=0; i<allCities.size(); i++) {
            System.out.println(allNames.get(i).getText() + " --- " + allCities.get(i).getText());
        }

    }
}
