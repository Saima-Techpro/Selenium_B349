package com.seleniumproject.day10;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.lang.management.MemoryUsage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C01_JsExecutor extends TestBase {

        /*
    Given user is on the https://www.amazon.com/
    When user click on “Account” link
    Then verify the page title contains “Your account”
    Then scroll to Amazon Music element at the bottom of the page
    Click on it
    Then verify Amazon Music page is displayed
    Scroll the page up and down

    NOTE: Use JavaScript Executor

    - JavaScript Executor is an interface in Selenium that provides methods to interact with browser directly
     */

    @Test
    public void jsExecutorTest() throws InterruptedException {
//        Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        driver.navigate().refresh();

        Actions actions = new Actions(driver);

        WebElement accountListOption = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountListOption).perform();  // moveToElement() is used to hover and scroll as well
        Thread.sleep(1000);

//        When user click on “Account” link
        WebElement accountLink = driver.findElement(By.linkText("Account"));
        // accountLink.click(); // normal click. If this doesn't work, we use actions.click()
        // actions.click(accountLink).perform(); // If this doesn't work as well. Then what should we do?

        // We can use JSExecutor methods
        // Step 1. type cast the driver into JavascriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", accountLink);

//        Then verify the page title contains “Your account”
        assertTrue(driver.getTitle().contains("Your Account"));
        Thread.sleep(1000);

//        Then scroll to Amazon Music element at the bottom of the page
        WebElement musicButton = driver.findElement(By.xpath("//a[@class='nav_a']//*[text()='Amazon Music']"));
        // actions.moveToElement(musicButton).perform();  // moveToElement() is used to hover and scroll as well
        // OR
        js.executeScript("arguments[0].scrollIntoView(true);", musicButton);
        Thread.sleep(1000);


//        Click on it
        // musicButton.click();
        // OR
        js.executeScript("arguments[0].click();", musicButton);

//        Then verify Amazon Music page is displayed
        assertTrue(driver.getCurrentUrl().contains("music"));

//        Scroll the page up and down
        js.executeScript("window.scrollTo(0, 150);"); // Vertical scroll by 150 pixels
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);"); // all the way down like PAGE_DOWN
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);"); // all the way up like PAGE_UP


        // Locate search bar and search for Pop music
         WebElement searchInput = driver.findElement(By.id("navbarSearchInput"));
         searchInput.sendKeys("Pop Music", Keys.ENTER);
         Thread.sleep(3000);

        // OR
       //js.executeScript("document.getElementById('navbarSearchInput').value = 'Pop music';");

        // Assert
        String header = driver.findElement(By.xpath("//h2//span")).getText();
        System.out.println("header = " + header);


        assertTrue(driver.findElement(By.xpath("//h2//span")).getText().contains("Pop Music"));











    }
}
