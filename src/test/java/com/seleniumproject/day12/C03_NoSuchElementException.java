package com.seleniumproject.day12;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C03_NoSuchElementException extends TestBase {

    @Test
    public void noSuchElementExceptionTest(){
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));  // NoSuchElementException
        // because page was not loaded properly and driver could not find this element

        searchBox.sendKeys("Teapot" , Keys.ENTER);

    }

    @Test
    public void noSuchElementExceptionTest2() {
        // Go to https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        // NOTE: these elements are inside an iframe, need to switch to that iframe first
        // driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // To drag the source to its target place, we need to use Actions class
        // 1. Create actions object
        Actions actions = new Actions(driver);
        // 2. now use this object to take any action
        actions.dragAndDrop(source, target).perform();
        // Assert
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='droppable']//p"));
        String messageText = successMessage.getText();
        assertEquals("Dropped!", messageText);

    }
}
