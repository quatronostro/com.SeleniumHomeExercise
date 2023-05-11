package practice.cydeo.com;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.WatchEvent;

public class P01_AddRemoveElements extends TestBase {

    @Test
    public void test(){
        //1. go to this website "https://practice.cydeo.com/add_remove_elements/"
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //2. click "Add Element" button
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();

        //3. Verify that you can see "Delete" button
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
        Assert.assertTrue(deleteButton.isDisplayed());

        //4. Click "Delete" button
        deleteButton.click();

        //Test Passed

    }

}
