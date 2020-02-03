package seleniumintro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SmartBear2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBear1.loginToSmartBear(driver);
        WebElement orderButton = driver.findElement(By.linkText("Order"));
        orderButton.click();

        WebElement product = driver.findElement(By.name("ctl00$MainContent$fmwOrder$ddlProduct"));
        Select select = new Select(product);
        select.selectByVisibleText("FamilyAlbum");

        WebElement quantity = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        quantity.sendKeys(Keys.BACK_SPACE+ "2");
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        WebElement customerName = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"));
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        customerName.sendKeys(fullName);

        WebElement street = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2"));
        String address = faker.address().streetAddress();
        street.sendKeys(address);

        WebElement city = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        String city1 = faker.address().city();
        city.sendKeys(city1);

        WebElement state = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        String state1 = faker.address().state();
        state.sendKeys(state1);

        WebElement zipCode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        String zip = faker.address().zipCode();
        zip = zip.replace("-", "");
        zipCode.sendKeys(zip);

        WebElement paymentType = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        paymentType.click();

        WebElement cardNumber = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6"));
        cardNumber.sendKeys(faker.number().digits(16));

        WebElement expireDate = driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1"));
        expireDate.sendKeys("12/2020");

        WebElement processButton = driver.findElement(By.linkText("Process"));
        processButton.click();

        // 13.Verify success message “New order has been successfully added.”
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        if(successMessage.isDisplayed()){
            System.out.println("Message displayed. Order placed. PASS!");
        }else{
            System.out.println("Message is not displayed. Order NOT placed. FAIL!!!");
        }

    }
}
