package testNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTestNGClass {

    //test annotation gets executed in alphabetical order
    @Test
    public void firstTest() {
        System.out.println("First test is running");

        Assert.assertEquals("actualValue", "actualValue", "1 test is failed");
        Assert.assertEquals(1,1, "int test failed");

    }
    @Test
    public void secondTest() {
        System.out.println("Second test is running");
        Assert.assertTrue("sentence".contains("e"), "sentence does not contain given letter");
    }

    //is running before every single method
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method is running");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method is running");
    }

    //before class is running once before
    // everything even if it's at the end only 1 time
    //we use it when we setting up smtg before everything ike for ex
    // driver, window maximizing, timeout etc
    @BeforeClass
    public void setUp() {
        System.out.println("Before Class is running");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After class is running");
    }
}
