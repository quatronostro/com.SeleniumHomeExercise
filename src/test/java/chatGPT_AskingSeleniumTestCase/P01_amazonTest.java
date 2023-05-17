package chatGPT_AskingSeleniumTestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P01_amazonTest extends TestBase {

    @Test
    public void test01(){
        //Test Case 1:
        //Website: www.amazon.com
        //Objective: Search for a product, apply filters, and add it to the cart.
        //
        //Steps:
        //
        //Launch the browser and navigate to www.amazon.com.
        driver.get("https://amazon.com");

        //Enter a specific product name in the search bar.
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys("nutella");

        //Click on the search button.
        searchBar.submit();

        //Apply relevant filters, such as price range or customer ratings.
        WebElement lowPriceBar = driver.findElement(By.xpath("//input[@id='low-price']"));
        lowPriceBar.click();

        Actions actions = new Actions(driver);
        actions.sendKeys("15")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys("45")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //Select a product from the search results.
        WebElement product = driver.findElement(By.xpath("//div[@data-index='7']"));
        product.click();

        //Verify that the product page is displayed.
        WebElement productImage = driver.findElement(By.xpath("//*[@data-csa-c-action=\"image-block-main-image-hover\"]"));
        Assert.assertTrue(productImage.isDisplayed());

        //Add the product to the cart.
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        //Verify that the product is successfully added to the cart.
        WebElement addedToCartText = driver.findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span"));
        String expectedString = "Added to Cart";
        String actualString = addedToCartText.getText();
        Assert.assertEquals(expectedString, actualString);

    }
}
