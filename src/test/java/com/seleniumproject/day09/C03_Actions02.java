package com.seleniumproject.day09;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.*;

public class C03_Actions02 extends TestBase {
    /*
    Given user is on the https://www.amazon.com/
    When user click on “Account” link
    Then verify the page title contains “Your account”
    Then scroll to Amazon Music element at the bottom of the page
    Click on it
    Then verify Amazon Music page is displayed
    Scroll the page up and down

     */


    @Test
    public void amazonTest() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
        driver.navigate().refresh(); // or locate the element 'Continue Shopping' and click on that
//        locating the element that I want to hover over
        WebElement accountListOption = driver.findElement(By.id("nav-link-accountList"));

        //hover over accountListOption
//        1. create Actions object
        Actions actions = new Actions(driver);
//        2. use moveToElement function to hover over to the element. make sure use perform() at the end
        actions.moveToElement(accountListOption).perform();  // moveToElement() is used to hover and scroll as well
        Thread.sleep(1000);
//    When user click on “Account” link
        WebElement accountLink = driver.findElement(By.linkText("Account"));
        accountLink.click(); //This is commonly used. But if in any case it doesn't work, we can use actions.click() also.
        // OR
        //actions.click(accountLink).perform();
        Thread.sleep(1000);
//    Then verify the page title contains “Your Account”
        assertTrue(driver.getTitle().contains("Your Account"));
        Thread.sleep(1000);
//    Then scroll to Amazon Music element at the bottom of the page
        // WebElement musicButton = driver.findElement(By.xpath("//*[text()='Amazon Music']"));
        // WebElement musicButton = driver.findElement(By.linkText("Amazon Music"));
        // WebElement musicButton = driver.findElement(By.partialLinkText("Amazon Music"));
         WebElement musicButton = driver.findElement(By.xpath("//a[@class='nav_a']//*[text()='Amazon Music']"));

        actions.moveToElement(musicButton).perform();  // moveToElement() is used to hover and scroll as well
        Thread.sleep(1000);
//    And click on it
        musicButton.click();
        //OR ALTERNATIVELY
        // actions.click(musicButton).perform();
        Thread.sleep(5000);



//    Then verify Amazon Music page is displayed
        String amazonMusicTitle = driver.getTitle();
        assertTrue(amazonMusicTitle.contains("Music"));
        // OR
        assertTrue(driver.getCurrentUrl().contains("music"));

//    Scroll the page up and down

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        // The other option
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);

        // We can also chain these methods
        // NOTE: build() method is not mandatory; it's used to ensure that method chain doesn't break
        // BUt perform() is mandatory.
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.PAGE_DOWN).
                build().
                perform();



    }


    
}
