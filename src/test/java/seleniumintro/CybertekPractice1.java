package seleniumintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CybertekPractice1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");

        // year
        WebElement year = driver.findElement(By.id("year"));
        Select selectY = new Select(year);
        String actualYear = selectY.getFirstSelectedOption().getText();


        // month
        WebElement month = driver.findElement(By.id("month"));
        Select selectM = new Select (month);
        String actualMonth = selectM.getFirstSelectedOption().getText();


        // day
        WebElement day = driver.findElement(By.id("day"));
        Select selectD = new Select (day);
        String actualDay = selectD.getFirstSelectedOption().getText();

        if (actualDay.equals("26") && actualMonth.equals("January") && actualYear.equals("2020")) {
            System.out.println("Current date verification PASSED");
        }
        else {
            System.out.println("Current date verification FAILED");
        }

        // select December 31, 1921
        selectY.selectByValue("1921");
        selectM.selectByIndex(11);
        selectD.selectByVisibleText("31");

        String exDay = "31";
        String exMonth = "December";
        String exYear = "1921";

        String aYear = selectY.getFirstSelectedOption().getText();
        String aMonth = selectM.getFirstSelectedOption().getText();
        String aDay = selectD.getFirstSelectedOption().getText();

        if (exYear.equals(aYear) && exMonth.equals(aMonth)&& exDay.equals(aDay)) {
            System.out.println("Selected date verification PASSED");
        }
        else {
            System.out.println("Selected date verification FAILED");
        }


        // second task


        WebElement selectAllDropdown = driver.findElement(By.name("Languages"));
        Select select = new Select(selectAllDropdown);

        List<WebElement> options = select.getOptions();
        for (WebElement option: options) {
            Thread.sleep(500);
            select.selectByVisibleText(option.getText());
        }

        //print all selected options
        List <WebElement> selectedOptions = select.getAllSelectedOptions();
        for (WebElement selectedOption: selectedOptions) {
            System.out.println(selectedOption.getText());
        }

        //deselect all options
        Thread.sleep(1000);
        select.deselectAll();









    }
}
