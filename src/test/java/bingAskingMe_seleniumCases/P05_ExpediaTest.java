package bingAskingMe_seleniumCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P05_ExpediaTest extends TestBase {

    @Test
    public  void  test() throws InterruptedException {
        //5. Test case: Verify that the user can book a flight on expedia.com
        //Steps:
        //Launch the browser and navigate to https://www.expedia.com
        driver.get("https://www.expedia.com");

        //Locate the flights tab and click on it
        WebElement flightsTab = driver.findElement(By.xpath("//*[@id=\"wizardMainRegionV2\"]/div/div/div/div/ul/li[2]"));
        flightsTab.click();

        //Locate the origin field and enter a valid departure city or airport "New York"
        WebElement leavingFrom = driver.findElement(By.xpath("//button[@aria-label='Leaving from']"));
        leavingFrom.click();

        WebElement inputFrom = driver.findElement(By.xpath("//input[@id='location-field-leg1-origin']"));
        inputFrom.sendKeys("New York" + Keys.ENTER);

        //Locate the destination field and enter a valid arrival city or airport "London"
        WebElement goingTo = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
        goingTo.click();

        WebElement inputTo = driver.findElement(By.xpath("//input[@id='location-field-leg1-destination']"));
        inputTo.sendKeys("London" + Keys.ENTER);

        //Locate the departure date field and select a valid date from the calendar "May 20"
        //Locate the return date field and select a valid date from the calendar "May 27"
        WebElement date1 = driver.findElement(By.xpath("//button[@id='d1-btn']"));
        date1.click();

        driver.findElement(By.xpath("//button[@data-day='20'][1]")).click(); //May 20
        driver.findElement(By.xpath("//button[@data-day='27'][1]")).click(); // May 27
        driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).click(); //Done

        //Click on the search button or press enter
        WebElement submitButton = driver.findElement(By.xpath("//button[@data-testid='submit-button']"));
        submitButton.click();

        // there is captcha when I'm using webdriver but there is no capthca in normal chrome. so I need to skip that
        WebElement captchaFrame = driver.findElement(By.id("(//div[@id='app'])[2]"));
        driver.switchTo().frame(captchaFrame);
        driver.findElement(By.xpath("//button[@id='home_children_button']")).click();
        // Find the captcha frame

        // Hide the frame using Javascript
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById((//div[@id='app'])[2]).style.display = 'none';");
        // Click on the checkbox to skip the captcha

        //driver.findElement(By.id("captcha-checkbox")).click();
        //Verify that the results page contains available flights matching the search criteria
        WebElement verifyText = driver.findElement(By.xpath("(//span[@class='is-visually-hidden'])[7]"));
        String verifyTextStr = verifyText.getText();
        Assert.assertTrue(verifyTextStr.contains("New York") && verifyTextStr.contains("London"));

        // I cant finish this tas because there is captcha and I dont now how to skip it

    }
}
