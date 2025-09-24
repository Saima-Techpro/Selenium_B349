package com.practices.practice02;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q02_DragAndDrop extends TestBase {

      /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below
    Then
        Verify they are dropped.
  */

    @Test
    public void dragAndDropTest() {
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        Actions actions = new Actions(driver);

        // Locate source elements (orange draggable items)
        WebElement bank = driver.findElement(By.xpath("//li[@id='credit2']/a")); // BANK
        WebElement sales = driver.findElement(By.xpath("//li[@id='credit1']/a")); // SALES
        WebElement amount1 = driver.findElement(By.xpath("//li[@id='fourth']/a")); // 5000
        WebElement amount2 = driver.findElement(By.xpath("//li[@id='fourth']/a")); // 5000 again

        // Locate target drop zones
        WebElement debitAccount = driver.findElement(By.xpath("//ol[@id='bank']"));
        WebElement creditAccount = driver.findElement(By.xpath("//ol[@id='loan']"));
        WebElement debitAmount = driver.findElement(By.xpath("//ol[@id='amt7']")); //Debit side
        WebElement creditAmount = driver.findElement(By.xpath("//ol[@id='amt8']"));//Credit

        // Perform drag and drop
        actions.dragAndDrop(bank, debitAccount).perform();
        actions.dragAndDrop(sales, creditAccount).perform();
        actions.dragAndDrop(amount1, debitAmount).perform();
        actions.dragAndDrop(amount2, creditAmount).perform();

        // Assertion
//        WebElement successMessage = driver.findElement(By.xpath("//a[contains(text(),'Perfect!')]"));
        WebElement successMessage = driver.findElement(By.linkText("Perfect!"));
        assertEquals("Perfect!", successMessage.getText());


    }


    @Test
    public void dragAndDropTest1() {

        driver.get("https://demo.guru99.com/test/drag_drop.html");

        Actions actions = new Actions(driver);

        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement bankTarget = driver.findElement(By.id("bank"));

        WebElement sales = driver.findElement(By.id("credit1"));
        WebElement salesTarget = driver.findElement(By.id("loan"));


        WebElement amount1 = driver.findElement(By.id("fourth")); // "5000"
        WebElement amountTarget1 = driver.findElement(By.id("amt7"));

        WebElement amount2 = driver.findElement(By.id("fourth")); // "5000" again
        WebElement amountTarget2 = driver.findElement(By.id("amt8"));

        actions.dragAndDrop(bank, bankTarget).perform();
        actions.dragAndDrop(sales, salesTarget).perform();
        actions.dragAndDrop(amount1, amountTarget1).perform();
        actions.dragAndDrop(amount2, amountTarget2).perform();


    }



}
