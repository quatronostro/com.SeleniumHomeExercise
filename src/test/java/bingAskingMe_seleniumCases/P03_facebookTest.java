package bingAskingMe_seleniumCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.HashMap;
import java.util.Map;

public class P03_facebookTest extends TestBase {

//    3. Test case: Verify that the user can sign in to their account on facebook.com
    @Test
    public void test01() throws InterruptedException {
//    Steps:
//    Launch the browser and navigate to https://www.facebook.com

        driver.get("https://www.facebook.com");

//    Locate the email or phone number field and enter a valid email or phone number associated with an existing account
        WebElement emailBox = driver.findElement(By.xpath("//*[@id='email']"));
        emailBox.sendKeys("berke.bar@hotmail.com");

//    Locate the password field and enter the correct password for the account
        WebElement passwordBox = driver.findElement(By.xpath("//*[@id='pass']"));
        passwordBox.sendKeys("********"); //I entered here my password but delete when I send this to github

//    Click on the login button or press enter
        driver.findElement(By.xpath("//*[@data-testid='royal_login_button']")).click();

        Thread.sleep(10000);


//    Verify that the user is redirected to their home page and their name is displayed in the top right corner of the page
        String actualUserName = driver.findElement(By.xpath("//*[@style='-webkit-box-orient:vertical;-webkit-line-clamp:2;display:-webkit-box'][1]")).getText();
        String expectedUserName = "Berke Baramuk";
        Assert.assertEquals(expectedUserName, actualUserName);


    }
}
