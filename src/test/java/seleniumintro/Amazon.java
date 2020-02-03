package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        WebElement amazonSearchBox=  driver.findElement(By.cssSelector("input[name='field-keywords']"));
        amazonSearchBox.sendKeys("cup");
        WebElement amazonSearchButton = driver.findElement(By.cssSelector("input[tabindex='20']"));
        amazonSearchBox.click();


    }
}
