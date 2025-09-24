package com.practices.practice02;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q01_AddRemoveButtons extends TestBase {
         /*
    Given
        Go to http://the-internet.herokuapp.com/add_remove_elements/
    When
        Click on the "Add Element" button 100 times
    And
        Click on the "Delete" button 20 times
    Then
        Assert that 20 buttons were deleted.
      */

    @Test
    public void addRemoveButtonsTest(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));

        // Click Add Element button 100 times
        for (int i = 0; i < 100; i++) {
            addButton.click();
        }

        // Click Delete button 20 times
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));


        for (int i = 0; i < 20; i++) {
            deleteButtons.get(i).click();
        }

        //  Assert that 20 buttons were deleted
        List<WebElement> remainingButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        assertEquals(80, remainingButtons.size());




    }

    @Test
    public void addRemoveButtonsTest1() throws InterruptedException {

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement clickAddElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        for (int i = 0; i < 100; i++) {
            clickAddElementButton.click();
        }
        Thread.sleep(2000);


        // Click "Delete" button 20 times
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        for (int i = 0; i < 20; i++) {
            deleteButtons.get(i).click();
        }

        // Assert that 20 buttons were deleted ( 80 remain)
        List<WebElement> remainingButtons = driver.findElements(By.className("added-manually"));
        assertEquals(80, remainingButtons.size());


    }
}
