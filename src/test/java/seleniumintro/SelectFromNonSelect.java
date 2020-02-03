package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SelectFromNonSelect {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement nonSelect = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        nonSelect.click();
        driver.findElement(By.linkText("Facebook")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Facebook title verification PASSED");
        }
        else {
            System.out.println("Facebook title verification FAILED");
        }

    }
}
