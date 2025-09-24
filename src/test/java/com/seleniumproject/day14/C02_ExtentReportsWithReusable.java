package com.seleniumproject.day14;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C02_ExtentReportsWithReusable extends TestBase {

    @Test
    public void extentReportTest() throws IOException {

        // Go to https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        waitFor(2);

        extentTest.addScreenCaptureFromPath(captureScreenshotEntirePageAsString());
        extentTest.pass("User is on autocomplete homepage");

        // Type "Uni" in the search box
        WebElement searchBox = driver.findElement(By.id("myCountry"));
        searchBox.sendKeys("Uni");
        waitFor(2);
        extentTest.addScreenCaptureFromPath(captureScreenshotEntirePageAsString());
        extentTest.info("User is typing Uni in the search box");

        // Select "United Kingdom" from the suggestions
        WebElement suggestion = driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']"));
        suggestion.click();
        waitFor(2);
        extentTest.addScreenCaptureFromPath(captureScreenshotEntirePageAsString());
        extentTest.info("User is selecting 'United Kingdom' from the suggestions");

        // Click on Submit
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='button']"));
        submitButton.click();
        waitFor(2);
        extentTest.addScreenCaptureFromPath(captureScreenshotEntirePageAsString());
        extentTest.pass("Submit button is clicked.");

        // Verify the result contains "United Kingdom"
        String successMessage = driver.findElement(By.id("result")).getText();

        assertEquals("You selected: United Kingdom", successMessage);
        waitFor(2);
        extentTest.addScreenCaptureFromPath(captureScreenshotEntirePageAsString());
        extentTest.pass("United Kingdom is successfully selected from the auto suggestions");




    }
}
