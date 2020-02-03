package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBox2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkAllButton = driver.findElement(By.xpath("//input[@type='button']"));
        //System.out.println(actualSelectAll);
        String checkAll = "Check All";
        String actualText = checkAllButton.getAttribute("value");

        if (checkAll.equals(actualText)) {
            System.out.println("Check all button verification passed");
        }
        else {
            System.out.println("Check all button verification failed");
        }
        checkAllButton.click();

        WebElement option1 = driver.findElement(By.xpath("(//div[@class='checkbox']/label/input)[2]"));
        WebElement option2 = driver.findElement(By.xpath("(//div[@class='checkbox']/label/input)[3]"));
        WebElement option3 = driver.findElement(By.xpath("(//div[@class='checkbox']/label/input)[4]"));
        WebElement option4 = driver.findElement(By.xpath("(//div[@class='checkbox']/label/input)[5]"));

        if (option1.isSelected() && option2.isSelected() && option3.isSelected() && option4.isSelected()) {
            System.out.println("All check buttons are selected. Verification passed.");
        }
        else {
            System.out.println("Not all check buttons are selected. Verification failed.");
        }


        WebElement uncheckedButton = driver.findElement(By.xpath("//input[@type='button']"));
        String actualTextForUncheckedButton = uncheckedButton.getAttribute("value");
        String expectedTextForUncheckedButton = "Uncheck All";

        if (actualTextForUncheckedButton.equals(expectedTextForUncheckedButton)) {
            System.out.println("Unchecked button verification passed.");
        }
        else {
            System.out.println("Unchecked button verification failed.");
        }
    }
}
