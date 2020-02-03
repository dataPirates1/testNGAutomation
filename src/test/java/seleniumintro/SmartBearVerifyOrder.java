package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBearVerifyOrder {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //type login, password and click

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //login to Smart Bear
        SmartBear1.loginToSmartBear(driver);

        //verify the name is in the list

        SmartBear1.verifyOrder(driver, "Paul Brown");
        SmartBear1.printNamesAndCities(driver);


    }
}
