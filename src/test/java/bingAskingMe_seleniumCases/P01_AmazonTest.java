package bingAskingMe_seleniumCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P01_AmazonTest extends TestBase {
        //1. Test case: Verify that the user can search for a product on amazon.com
    @Test
    public void test01(){
//        Steps:
//        Launch the browser and navigate to https://www.amazon.com
        driver.get("https://www.amazon.com");

//        Locate the search box and enter a product name "headphones"
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("headphones");

//        Click on the search button or press enter
        searchBox.submit();

//        Verify that the results page contains relevant products matching the search query
        String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]")).getText();
        String expectedText = "headphones";
        Assert.assertTrue(actualText.contains(expectedText));

    }
}
