package chatGPT_AskingSeleniumTestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03_LinkedinTest extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //Test Case 3:
        //Website: www.linkedin.com
        //Objective: Log in with valid credentials and send a connection request to a specific person.
        //
        //Steps:
        //
        //Launch the browser and navigate to www.linkedin.com.
        driver.get("https://www.linkedin.com");

        //Enter valid login credentials and click on the "Sign In" button.
        WebElement emailBox = driver.findElement(By.xpath("//*[@autocomplete='username']"));
        emailBox.sendKeys("b.baramuk@gmail.com");
        WebElement passwordBox = driver.findElement(By.xpath("//*[@autocomplete='current-password']"));
        passwordBox.sendKeys("BEr.Bar.1993");
        driver.findElement(By.xpath("//*[@data-id='sign-in-form__submit-btn']")).click();

        //Verify that the user is successfully logged in.
        WebElement myProfileName = driver.findElement(By.xpath("(//*[@class='t-16 t-black t-bold'])[1]"));
        String actualName = myProfileName.getText();
        String expectedName = "Berke Baramuk";
        Assert.assertEquals(expectedName, actualName);

        //Search for a specific person using their name or profile details.
        WebElement searchBox = driver.findElement(By.className("search-global-typeahead__input"));
        searchBox.click();
        Actions actions = new Actions(driver);
        actions.sendKeys("lisa").perform();
        Thread.sleep(1000);
        actions.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN)
                //.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
//        searchBox.click();
//        searchBox.sendKeys("lisa bernard" + Keys.ARROW_DOWN + Keys.ENTER);

        //Select the desired person from the search results.
        WebElement lisaProfile = driver.findElement(By.xpath("(//a[@*='https://www.linkedin.com/in/bernardlisa?miniProfileUrn=urn%3Ali%3Afs_miniProfile%3AACoAABhI51IBtlDqmmjXBxSiuN8mqxOLgJkUZeE'])[1]"));
        lisaProfile.click();
        Thread.sleep(2000);

        //Click on the "Connect" button to send a connection request.
        WebElement moreButton = driver.findElement(By.xpath("(//*[@aria-label='More actions'])[2]"));
        moreButton.click();
        WebElement connectButton = driver.findElement(By.xpath("(//*[@aria-label='Invite Lisa Bernard to connect'])[2]"));
        connectButton.click();
        WebElement sendButton = driver.findElement(By.xpath("//*[@aria-label=\"Send now\"]"));
        sendButton.click();

       // I send connection to my ex, so it didnt find locate to verify that at last part but I saw with my eyes and thats enough adventure for today :)
    }
}
