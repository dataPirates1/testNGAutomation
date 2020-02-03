package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Craigslist {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://chicago.craigslist.org/d/financial-services/search/fns");

        // 1. check if search field is working
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='search financial services']"));
        searchField.sendKeys("accounting");
       // 2. check if search button is working
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='searchbtn changed_input clickme']"));
        searchButton.click();

        //3. check if URL contains the word "accounting"
        String actualURL = driver.getCurrentUrl();
        String URLcontains = "accounting";

        if (actualURL.contains(URLcontains)) {
            System.out.println("URL verification PASSED");
        }
        else {
            System.out.println("URL verification FAILED");
        }

        //4. check if RESET button is working properly

        WebElement resetButton = driver.findElement(By.partialLinkText("reset"));
        resetButton.click();

        String searchFieldValue = searchField.getAttribute("value");
        System.out.println(searchFieldValue);
        // ask Asel how to check that search field is empty now. getting exception
        // because value element doesn't exist anymore




    }
}
