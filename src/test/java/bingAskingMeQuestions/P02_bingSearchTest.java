package bingAskingMeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class P02_bingSearchTest {
    WebDriver driver;
    @Before
    public void setuo(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        // going to bing.com
        driver.get("https://bing.com");

        // locating search bar and searching for "selenium" on the Bing
        driver.findElement(By.xpath("//button[@id='bnp_btn_reject']")).click(); // this code for rejecting cookies

        WebElement searchBar = driver.findElement(By.xpath("//*[@id='sb_form_q']"));
        searchBar.click();
        searchBar.sendKeys("selenium" + Keys.ENTER);
        //verifying first result is selenium's website
        String actualResult = driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[1]/div[1]/div[2]/a[2]//cite")).getText();
        String expectedResult = "https://www.selenium.dev";
        Assert.assertEquals(expectedResult, actualResult);

    }
}
