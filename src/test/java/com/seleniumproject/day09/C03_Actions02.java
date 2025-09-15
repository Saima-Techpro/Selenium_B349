package com.seleniumproject.day09;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        driver.navigate().refresh();
//        locating the element that I want to hover over
        WebElement accountListTab = driver.findElement(By.id("nav-link-accountList"));

        //hover over accountListTab
//        1. create Actions object
        Actions actions = new Actions(driver);
//        2. use moveToElement function to hover over to the element. make sure use perform() at the end
        actions.moveToElement(accountListTab).perform();  // moveToElement() is used to hover and scroll as well
        Thread.sleep(1000);
//    When user click on “Account” link
        WebElement accountLink = driver.findElement(By.linkText("Account"));
//        accountLink.click(); //no need actions. this is more common.
//        but ALTERNATIVELY I can use actions to click
        actions.click(accountLink).perform();
        Thread.sleep(1000);
//    Then verify the page title contains “Your Account”
        assertTrue(driver.getTitle().contains("Your Account"));
        Thread.sleep(1000);
//    Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        // WebElement amazonMusic = driver.findElement(By.partialLinkText("Amazon Music"));
        actions.moveToElement(amazonMusic).perform();  // moveToElement() is used to hover and scroll as well
        Thread.sleep(1000);
//    And click on it
//        amazonMusic.click(); //OR ALTERNATIVELY
        actions.click(amazonMusic).perform();
        Thread.sleep(3000);
//    Then verify Amazon Music page is displayed
        assertTrue(driver.getCurrentUrl().contains("music"));

//    Scroll the page up and down
        actions.sendKeys(Keys.PAGE_DOWN).perform();//scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//scrolling down
        Thread.sleep(3000);
        // ANOTHER WAY IS WITH ARROWS .. But this will scroll down less as compared to page_down
        actions.sendKeys(Keys.ARROW_DOWN).perform();//scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();//scrolling down
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();//scrolling up
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();//scrolling up
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();//scrolling up
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();//scrolling up
        Thread.sleep(3000);

        // To build a chain of actions and perform all together, we use build() and perform()
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();

    }



    
}
