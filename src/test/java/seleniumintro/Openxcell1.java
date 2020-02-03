package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Openxcell1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.openxcell.com");
        List<WebElement> list = driver.findElements(By.xpath("//body//a"));


        // part 1
        System.out.println(list.size());
        if (list.size()==188) {
            System.out.println("Number of links verification PASSED.");
        }
        else {
            System.out.println("Number of links verification FAILED.");
        }

        // part 2 : print text of the links

        for (WebElement wb: list) {
            if (wb.getText().isEmpty()) {
                continue;
            }
            System.out.println(wb.getText());
        }

        // part 3
        int count = 0;
        for (WebElement wb: list) {
            if (wb.getText().isEmpty()) {
                count++;
            }
        }
        System.out.println(count);

        if (count ==109) {
            System.out.println("Empty links verification PASSED");
        }
        else {
            System.out.println("Empty links verification FAILED");
        }

    }
}
