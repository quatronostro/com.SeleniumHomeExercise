package practice.cydeo.com;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Autocomplete extends TestBase {

    @Test
    public void test(){
        //1. go to this website : "https://practice.cydeo.com/autocomplete"
        driver.get("https://practice.cydeo.com/autocomplete");

        //2. locate "Country" Element and click
        WebElement autocomplete = driver.findElement(By.xpath("//*[@id=\"myCountry\"]"));
        autocomplete.click();

        //3. write "tur" on the input country element
        autocomplete.sendKeys("tur");

        //4. click "Turkey" on the list
        driver.findElement(By.xpath("//*[@id=\"myCountryautocomplete-list\"]/div[1]/strong")).click();

        //5. click to "Submit" button
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/form/input")).click();

        //6. Make sure you see "You selected: Turkey" text
        String expectedText = "You selected: Turkey";
        String actualText = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        Assert.assertEquals(expectedText, actualText);


    }

}
