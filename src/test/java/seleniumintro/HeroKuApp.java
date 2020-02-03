package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeroKuApp {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("aaa@gmail.com");
        driver.findElement(By.id("form_submit")).click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "email_sent";
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("URL verification passed");
        }
        else {
            System.out.println("URL verification failed");
        }

        String actualTextElement = driver.findElement(By.id("content")).getText();
        String expectedTextElement = "Your e-mail's been sent!";
        if (actualTextElement.equals(expectedTextElement)) {
            System.out.println("Text box verification passed");
        }
        else {
            System.out.println("Text box verification failed");
        }


        driver.close();

    }
}
