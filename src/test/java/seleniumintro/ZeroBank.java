package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        String actualHeader = driver.findElement(By.className("page-header")).getText();
        String expectedHeader = "Log in to ZeroBank";

        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Header verification passed");
        }
        else {
            System.out.println("Header verification failed");
        }

        System.out.println();
        System.out.println();

        String link = driver.findElement(By.partialLinkText("Forgot your password")).getAttribute("href");
        //Thread.sleep(5000);

        if (link.contains("forgot-password.html")) {
            System.out.println("URL verification passed");
        }
        else  {
            System.out.println("URL verification failed");
        }

        driver.close();




    }
}
