package chatGPT_AskingSeleniumTestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class P05_GmailTest extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //Test Case 4:
        //Website: www.gmail.com
        //Objective: Log in to a Gmail account, compose an email with attachments, and send it.
        //
        //Steps:
        //
        //Launch the browser and navigate to www.gmail.com.
        driver.get("https://www.gmail.com");

        //Enter valid login credentials and click on the "Sign In" button.
        //driver.findElement(By.xpath("//*[@data-action='sign in']")).click();

        WebElement emailBox = driver.findElement(By.id("identifierId"));
        emailBox.sendKeys("b.baramuk@gmail.com");

        driver.findElement(By.xpath("(//*[@jsname='V67aGc'])[2]")).click(); //next button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));



        WebElement passwordBox = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordBox));
        passwordBox.sendKeys("*******");

        WebElement nextButton = driver.findElement(By.id("passwordNext"));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();

        //Verify that the user is successfully logged in.
        WebElement profileIcon = driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a/img"));
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
        profileIcon.click();

        WebElement myName = driver.findElement(By.xpath("//*[@*='znj3je']"));
        String expectedName = "Berke Baramuk";
        String actualName = myName.getText();

        Assert.assertEquals(expectedName, actualName);

        //Click on the "Compose" button to create a new email.
        driver.findElement(By.className("T-I T-I-KE L3")).click();

        //Enter the recipient's email address, subject, and body of the email.
        WebElement toWho = driver.findElement(By.className("agP aFw"));
        toWho.sendKeys("berke.bar@hotmail.com");

        //Attach specific files to the email.
        WebElement attach = driver.findElement(By.className("a1 aaA aMZ"));
        attach.click();

        String differentForEveryone = System.getProperty("user.dir");
        String sameForEveryone = "src/test/java/chatGPT_AskingSeleniumTestCase/P05_AttachmentFile.txt";
        String filePath = differentForEveryone + sameForEveryone;

        attach.sendKeys(filePath);
        Thread.sleep(3000);

        //Click on the "Send" button.
        //Verify that the email is sent successfully.


        //it didnt work, it is too hard to automate gmail with this security precaution
        //so I will pass this task for now
    }
}
