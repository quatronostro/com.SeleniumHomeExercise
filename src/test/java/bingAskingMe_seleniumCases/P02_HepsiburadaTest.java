package bingAskingMe_seleniumCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class P02_HepsiburadaTest extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //2. Test case: Verify that the user can add a product to the shopping cart on ebay.com
//        Steps:
//        Launch the browser and navigate to https://www.hepsiburada.com
        driver.get("https://www.hepsiburada.com");
        String firstWindowHandle = driver.getWindowHandle();

        //accept cookies
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
//        Locate the search box and enter a product name "laptop"
        WebElement searchBox = driver.findElement(By.xpath("//input[@*='text']"));
        searchBox.click();
        searchBox.sendKeys("laptop" + Keys.ENTER);

//        Select a product from the results page by clicking on its title or image
        WebElement firstProduct = driver.findElement(By.xpath("//*[@id=\"i0\"]/div/a"));
        firstProduct.click();

        //it's opening in a new tab
        String secondWindowHandle = "";
        Set<String> windowHandleSet = driver.getWindowHandles();
        for (String eachWindowHandle: windowHandleSet) {
            if (!eachWindowHandle.contains(firstWindowHandle)){
                secondWindowHandle = eachWindowHandle;
            }
        }
        driver.switchTo().window(secondWindowHandle);
        Thread.sleep(2000);

//        On the product page, click on the add to cart button
        //WebElement actionElement = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/section[1]/div[3]/div/div[4]/div[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("addToCart"))).click().perform();
        //driver.findElement(By.xpath("//*[@id=\"addToCartForm\"]/span")).click();
        Thread.sleep(7000);
//        Verify that the product is added to the cart and the cart icon shows the correct number of items
//        driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]")).click();
//        WebElement checkBox = driver.findElement(By.id("selectedCheckBox"));
//        Assert.assertTrue(checkBox.isSelected());

        String actualVerifyText = driver.findElement(By.xpath("//span[@class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']")).getText();
        String expectedVerifyText = "Ürün sepetinizde";
        Assert.assertTrue(actualVerifyText.contains(expectedVerifyText));
    }
}
