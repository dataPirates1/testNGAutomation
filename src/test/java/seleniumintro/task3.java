package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.linkText("Gmail")).click();

        if(driver.getTitle().contains("Gmail")) {
            System.out.println("Gmail Title verification passed");
        }
        else {
            System.out.println("Title verification failed");
        }
        driver.navigate().back();
        if(driver.getTitle().contains("Google")) {
            System.out.println("Google Title verification passed");
        }
        else {
            System.out.println("Title verification failed");
        }
        driver.navigate().forward();


       // driver.findElement(By.name("q"));
        if(driver.getTitle().contains("Gmail")) {
            System.out.println("Gmail Title verification passed again");
        }
        else {
            System.out.println("Title verification failed");
        }

        driver.close();
    }
}
