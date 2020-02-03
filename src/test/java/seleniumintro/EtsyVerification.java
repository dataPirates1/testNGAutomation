package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com");
        driver.findElement(By.name("search_query")).sendKeys("wooden spoon" + Keys.ENTER);

        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title verification passed");
        }
        else {
            System.out.println("Title verification failed");
        }


    }
}
