package chatGPT_AskingSeleniumTestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class P02_netflixTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //Test Case 2:
        //Website: www.netflix.com
        //Objective: Sign up for a new account and perform a search for a TV show.
        //
        //Steps:
        //
        //Launch the browser and navigate to www.netflix.com.
        driver.get("https://netflix.com");

        //Click on the "Log In" button.
        WebElement cookieAccept = driver.findElement(By.xpath("(//button[@role='button'])[1]"));
        cookieAccept.click();

        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Oturum Aç']"));
        loginButton.click();

        //Enter valid information details, including name, email, and password.
        WebElement emailBox = driver.findElement(By.xpath("//label[@for='id_userLoginId']"));
        emailBox.click();

        Actions actions = new Actions(driver);
        actions.sendKeys("mbaramuk@hotmail.com")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys("******") //You cant see my password :)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //Access your profile and verify that the user is logged in.
        WebElement profile = driver.findElement(By.xpath("(//li[@class='profile'])[2]"));
        profile.click();

        WebElement accountDropDown = driver.findElement(By.xpath("//div[@class='account-dropdown-button']"));
        actions.moveToElement(accountDropDown).perform();

        WebElement profileName = driver.findElement(By.xpath("//span[@class='profile-name']"));
        String profileNameStr = profileName.getText();
        String expectedName = "mbaramuk";
        Assert.assertEquals(expectedName, profileNameStr);


        //Perform a search for a specific TV show.
        WebElement searchIcon = driver.findElement(By.className("search-icon"));
        actions.moveToElement(searchIcon).click().sendKeys("Breaking Bad").perform();
        Thread.sleep(2000);

        //Verify that the search results display the TV show and relevant information.
        WebElement tvShow = driver.findElement(By.xpath("(//p[@class='fallback-text'])[1]"));
        String tvShowStr = tvShow.getText();
        String expectedTvShow = "Breaking Bad";
        Assert.assertEquals(expectedTvShow, tvShowStr);

    }
}
