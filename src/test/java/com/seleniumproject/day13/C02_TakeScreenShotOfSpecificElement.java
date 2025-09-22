package com.seleniumproject.day13;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C02_TakeScreenShotOfSpecificElement extends TestBase {

    @Test
    public void autoCompleteTest(){
        // Go to https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        waitFor(2);
        // 1.
        captureScreenshotEntirePage();

        // Type "Uni" in the search box
        WebElement searchBox = driver.findElement(By.id("myCountry"));
        searchBox.sendKeys("Uni");

        //2.
        waitFor(2);
        captureScreenshotOfElement(searchBox);

        // Select "United Kingdom" from the suggestions
        WebElement suggestion = driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']"));
        //3.
        waitFor(2);
        captureScreenshotOfElement(suggestion);

        // OR
        captureScreenshotEntirePage(); // if you want to show all suggestions
        suggestion.click();

        // Click on Submit
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='button']"));
        // 4.
        waitFor(2);
        captureScreenshotOfElement(submitButton);
        submitButton.click();

        // Verify the result contains "United Kingdom"
        String successMessage = driver.findElement(By.id("result")).getText();
        assertEquals("You selected: United Kingdom", successMessage);

        //5.
        waitFor(2);
        captureScreenshotEntirePage();



    }
}
