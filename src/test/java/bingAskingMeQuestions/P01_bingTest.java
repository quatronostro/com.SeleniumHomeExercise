package bingAskingMeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class P01_bingTest {

    @Test
    public void test(){

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://bing.com");

        // verifying title of the "Bing" homepage is "Bing"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bing";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        driver.close();
    }
}
