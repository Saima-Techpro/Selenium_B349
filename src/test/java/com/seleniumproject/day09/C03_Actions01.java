package com.seleniumproject.day09;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C03_Actions01 extends TestBase {
    /*
Actions is used to perform mouse and keyboard action
We need to create an Actions object to perform action
Then use the appropriate function to perform mouse or keyboard events
Make sure to use perform() at the end

actions.moveToElement(target element).perform();-> hover over the element
actions.sendKeys(Keys.PAGE_DOWN).perform(); //scrolling down
actions.sendKeys(Keys.PAGE_UP).perform();//scrolling up
actions.sendKeys(Keys.ARROW_DOWN).perform();//scrolling down
actions.sendKeys(Keys.ARROW_UP).perform();//scrolling up

Difference between Arrow and Page is Arrow scrolls less than Page

We can use multiple actions function : actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
    - build() is not mandatory, but it is recommended to use when there is method chain.
    - perform() is MANDATORY; without this method, actions will not work

 */


    @Test
    public void dragDropTest() throws InterruptedException {
        // Go to https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        // Locate the source and target elements
        // NOTE: these elements are inside an iframe, need to switch to that iframe first
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // To drag the source to its target place, we need to use Actions class
        // 1. Create actions object
        Actions actions = new Actions(driver);

        // 2. now use this object to take any action
        // Hard wait
        Thread.sleep(3000);
        actions.dragAndDrop(source, target).perform();

        // Assert
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='droppable']//p"));
        String messageText = successMessage.getText();

        assertEquals("Dropped!", messageText);



    }
}
