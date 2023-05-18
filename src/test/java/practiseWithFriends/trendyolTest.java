package practiseWithFriends;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class trendyolTest {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void test() {

        driver.get("https://trendyol.com");
        String ilkWindow = driver.getWindowHandle();

        driver.findElement(By.id("Group-38")).click(); //poop-up
        driver.findElement(By.id("onetrust-accept-btn-handler")).click(); //cookies
        WebElement evMobilyaElement = driver.findElement(By.xpath("//*[@id=\"navigation-wrapper\"]/nav/ul/li[4]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(evMobilyaElement).perform();
        WebElement yemekTakimi = driver.findElement(By.linkText("Yemek Takımı"));
        yemekTakimi.click();
        WebElement ucuncuUrun = driver.findElement(By.xpath("(//*[@data-id])[5]"));
        ucuncuUrun.click();

        Set<String> windowHandleSet = driver.getWindowHandles();
        String ikinciWindow = "";
        for (String eachWindow: windowHandleSet) {
            if (!eachWindow.equals(ikinciWindow)){
                ikinciWindow = eachWindow;
            }
        }

        driver.switchTo().window(ikinciWindow);

        WebElement addToBasket = driver.findElement(By.className("add-to-basket-button-text"));
        addToBasket.click();

        WebElement sepetim = driver.findElement(By.xpath("(//*[@*='link-text'])[3]"));
        actions.moveToElement(sepetim).perform();

        WebElement urunResim = driver.findElement(By.xpath("//img[@*='basket-preview-product-image']"));

        Assert.assertTrue(urunResim.isDisplayed());

    }


    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
