package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DropdownPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");

        // locate the element
        WebElement stateDropdown = driver.findElement(By.id("state"));
        Select select = new Select(stateDropdown);

        // to get default value
        System.out.println(select.getFirstSelectedOption().getText());

        //select california
        Thread.sleep(1000);
        select.selectByVisibleText("California");

        // select by index
        Thread.sleep(1000);
        select.selectByIndex(12);

        //select by value
        Thread.sleep(1000);
        select.selectByValue("FL");

        String expectedOption = "Florida";
        String actualOption = select.getFirstSelectedOption().getText();

        if (expectedOption.equals(actualOption)) {
            System.out.println("Selected option verification PASSED");
        }
        else {
            System.out.println("Selected option verification FAILED");
        }


    }
}
