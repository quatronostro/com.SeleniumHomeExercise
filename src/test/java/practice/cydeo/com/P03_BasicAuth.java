package practice.cydeo.com;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P03_BasicAuth extends TestBase {

    @Test
    public void test(){
        // go to this website "https://practice.cydeo.com/basic_auth"
        // BUT you have to enter user and password = admin
        driver.get("https://admin:admin@practice.cydeo.com/basic_auth");

        // verify that you have entered correctly
        String expectedText = "Congratulations! You must have the proper credentials.";
        String actualText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
        Assert.assertEquals(expectedText, actualText);

        //TEST PASSED

    }
}
