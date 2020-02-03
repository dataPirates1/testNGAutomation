package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("apple");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
// or driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);
        String expectedTitle = "apple";
        String actualTitle = driver.getTitle();

        if(actualTitle.startsWith(expectedTitle)) {
            System.out.println("Title of search verification passed");
        }
        else {
            System.out.println("Title of search verification failed");
        }

        driver.close();

    }
}
