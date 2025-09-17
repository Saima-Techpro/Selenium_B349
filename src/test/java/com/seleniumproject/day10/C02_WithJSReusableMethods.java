package com.seleniumproject.day10;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C02_WithJSReusableMethods extends TestBase {

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

        // JSExecutor Reusable methods
        clickByJS(accountLink);
//        Then verify the page title contains “Your account”
        assertTrue(driver.getTitle().contains("Your Account"));
        Thread.sleep(1000);

//        Then scroll to Amazon Music element at the bottom of the page
        WebElement musicButton = driver.findElement(By.xpath("//a[@class='nav_a']//*[text()='Amazon Music']"));
        scrollIntoViewJS(musicButton);

//        Click on it
        clickByJS(musicButton);

//        Then verify Amazon Music page is displayed
        assertTrue(driver.getCurrentUrl().contains("music"));

//        Scroll the page up and down
        scrollAllDownJS();
        scrollAllUpJS();

        // Locate search bar and search for Pop music
        WebElement searchInput = driver.findElement(By.id("navbarSearchInput"));
        setValueByJS(searchInput, "Pop Music");
        Thread.sleep(3000);

        // Assert
        String header = driver.findElement(By.xpath("//h2//span")).getText();
        System.out.println("header = " + header);

        assertTrue(driver.findElement(By.xpath("//h2//span")).getText().contains("Pop Music"));


    }
}
