package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // sets up the driver
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        if (title.equals("Google")) {
            System.out.println("Title verification passed");
        }
        else
        System.out.println("Title verification failed");

        driver.close();

    }
}
