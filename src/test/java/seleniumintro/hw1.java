package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hw1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx/");
        if (driver.getTitle().equals("Web Orders Login")) {
            System.out.println("Title verification passed");
        }
        else {
            System.out.println("Title verification failed");
        }
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();


        if (driver.getTitle().equals("Web Orders")) {
            System.out.println("Title verification passed");
        }
        else {
            System.out.println("Title verification failed");
        }

    driver.close();
    }
}
