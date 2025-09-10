package com.seleniumproject.day07;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C03_AutoComplete extends TestBase {

    @Test
    public void autoCompleteTest(){
        // Go to https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

        // Type "Uni" in the search box
        WebElement searchBox = driver.findElement(By.id("myCountry"));
        searchBox.sendKeys("Uni");

        // Select "United Kingdom" from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();

        // Click on Submit
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='button']"));
        submitButton.click();

        // Verify the result contains "United Kingdom"
        String successMessage = driver.findElement(By.id("result")).getText();

        assertEquals("You selected: United Kingdom", successMessage);


    }
}
