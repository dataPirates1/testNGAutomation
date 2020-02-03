package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task2 {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cybertekschool.com");
        Thread.sleep(10000);
        driver.manage().window().maximize();
        String url = driver.getCurrentUrl();
        if (url.contains("cybertekschool")) {
            System.out.println("passed");
        }
        else System.out.println("failed");

        String title = driver.getTitle();
        if (title.equalsIgnoreCase("Cybertek")) {
            System.out.println("passed");
        }
        else System.out.println("failed");

//        driver.close();


    }
}
