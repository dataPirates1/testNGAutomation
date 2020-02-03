package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank2 {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();

        if (driver.findElement(By.linkText("username")).isDisplayed()) {
            System.out.println("Username verification passed");
        }
        else {
            System.out.println("Username verification failed");
        }
        //Thread.sleep(5000);
        String expectedTitle = "Zero - Account Summary";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification passed");
        }
        else {
            System.out.println("Title verification failed");
        }

        String linkExpected = "account-summary";
        String linkActual = driver.findElement(By.partialLinkText("Account Summary")).getAttribute("href");
        if (linkActual.contains(linkExpected)) {
            System.out.println("Link verification passed");
        }
        else {
            System.out.println("Link verification failed");
        }
        driver.close();

    }
}
