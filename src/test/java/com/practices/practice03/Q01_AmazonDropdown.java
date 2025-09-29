package com.practices.practice03;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Q01_AmazonDropdown extends TestBase {
    /*
       - Go to https://amazon.com
       - Print all the options in the 'Departments' dropdown on the left side of the search box
       - Search for each first five options and print titles
   */

    @Test
    public void amazonDropdownTest(){
        //  Amazon
        driver.get("https://www.amazon.com");
        waitFor(2);
        driver.navigate().refresh();

        // Locate the dropdown
        WebElement dropdownElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdownElement);

        //  Task 1: Get all options and print all the options
        List<WebElement> allOptions = select.getOptions();
        System.out.println("Total number of options: " + allOptions.size());

        // Print all the options
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }
        System.out.println("=========================");

        // Task 2: Search for each first five options and print titles
        for (int i = 1; i <= 5; i++) {
            //  allOptions.get(i).click(); We got staleElementException.. it means we need to relocate / refresh the element
            // String dropdownOption = allOptions.get(i).getText();

            WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
            List<WebElement> dropdownOptions = new Select(dropdown).getOptions();
            String dropdownOption = dropdownOptions.get(i).getText();

            waitFor(1);

            System.out.println(dropdownOption); // Arts & Crafts
            waitFor(2);

            // Locate search box
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys(dropdownOption, Keys.ENTER);

            waitFor(2);

            // Assert as well
            assertTrue(driver.getTitle().contains(dropdownOption));
            // NOTE: We got stale element exception for search box too... that's why we have to refresh the locator
            searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.clear();

        }


    }
}

