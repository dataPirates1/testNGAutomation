package testNG;
import org.testng.annotations.Test;
/*
This class does
 */
public class OrderOfThings {

    @Test (priority = -1 )
    public void firstTest(){
        System.out.println("Test one is running");
    }
    //final int i=0;
    //
    @Test (priority = 2)
    public void secondTest(){
        System.out.println("Test two is running");
    }
    //....
    @Test
    public void thirdTest(){
        System.out.println("Test three is running");
    }
}
