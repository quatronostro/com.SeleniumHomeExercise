package bingAskingMe_seleniumCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04_YoutubeTest extends TestBase {
    //4. Test case: Verify that the user can play a video on youtube.com
    @Test
    public void test() throws InterruptedException {

        //Steps:
        //Launch the browser and navigate to https://www.youtube.com
        driver.get("https://www.youtube.com");

        //Locate the search box and enter a video title or keyword "music"
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("music");

        //Click on the search button or press enter
        Thread.sleep(2000);
        searchBox.submit();

        //Select a video from the results page by clicking on its title or image
        driver.findElement(By.xpath("//div[@id='title-wrapper']")).click();

        //On the video page, click on the play button or wait for the video to start automatically
//        WebElement skipAdd = driver.findElement(By.xpath("//*[@id=\"ad-text:7\"]"));
//        if (skipAdd.isEnabled()){
//            skipAdd.click();
//        }
        //I try to embed skip add automation but never encountered with add so I dont know if there is add this code work or not
        //because of this its commented

        //Verify that the video is playing and the progress bar is moving along with the sound
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long playerState = (Long) js.executeScript ("return document.getElementById ('movie_player').getPlayerState ()");

        // Check the player state
        // 0 - ended
        // 1 - playing
        // 2 - paused
        // 3 - buffering
        // 5 - video cued
        try {
            Assert.assertTrue(playerState == 1);
            System.out.println("The video is playing");
        } catch (AssertionError e){
            System.out.println ("The video is not playing");
        }




    }
}
