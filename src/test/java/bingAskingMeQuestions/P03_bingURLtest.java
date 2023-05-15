package bingAskingMeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class P03_bingURLtest {

    @Test
    public void test(){

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://bing.com");

        driver.findElement(By.xpath("//button[@id='bnp_btn_reject']")).click(); // this code for rejecting cookies

        //locate images button
        WebElement images = driver.findElement(By.xpath("//*[@id='images']"));
        images.click();

        //verify that url contains images
        String actualURL = driver.getCurrentUrl();
        String expectedTextInURL = "images";
        Assert.assertTrue(actualURL.contains(expectedTextInURL));

        driver.close();

    }
}
