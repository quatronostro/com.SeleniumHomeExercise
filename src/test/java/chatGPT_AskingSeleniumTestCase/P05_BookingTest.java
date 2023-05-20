package chatGPT_AskingSeleniumTestCase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P05_BookingTest extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //Test Case 5:
        //Website: www.booking.com
        //Objective: Perform a hotel search, select a hotel, and verify the booking details.
        //
        //Steps:
        //
        //Launch the browser and navigate to www.booking.com.
        driver.get("https://www.booking.com");
        driver.findElement(By.xpath("//*[@aria-label='Dismiss sign-in info.']")).click(); // dismiss sign in button

        //Enter a specific location and travel dates in the search bar.
        //Click on the "Search" button.
        WebElement destination = driver.findElement(By.xpath("//*[@id=\":Ra9:\"]"));

        Actions actions = new Actions(driver);
        actions.click(destination).sendKeys("Paris")
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.ARROW_LEFT).keyUp(Keys.ARROW_LEFT)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.ENTER).keyUp(Keys.ENTER)
                .keyDown(Keys.TAB).keyUp(Keys.TAB)
                .keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

        //Verify that the search results display available hotels.

        //Select a specific hotel from the search results.
        //Verify that the hotel details page is displayed.
        //Check the booking options, such as room types and prices.
        //Verify that the booking details match the selected options.
    }
}
