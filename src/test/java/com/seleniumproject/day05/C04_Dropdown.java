package com.seleniumproject.day05;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C04_Dropdown {

    WebDriver driver;


    @BeforeEach
    public void setUp(){
        // Common steps
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Implicit wait
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void dropDownTest() throws InterruptedException {

        // Locate the dropdown
        WebElement firstDropDown = driver.findElement(By.id("dropdown"));

        // To interact with dropdowns, we need 2 steps:
        // 1. Create a select object
        // 2. Use that object to select options using selectByIndex() , selectByValue() or selectByVisibleText()

        // 1.
        Select select = new Select(firstDropDown);

        Thread.sleep(3000);
        //2.
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByValue("1");
        Thread.sleep(3000);
        select.selectByVisibleText("Option 2");


    }
    @Test
    public void getAllOptions(){
        WebElement firstDropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(firstDropDown);
        // NOTE: getOptions() method returns a list of WebElements, so we need to create a list to store them
        List<WebElement> optionList = select.getOptions();


        for (WebElement eachOption : optionList){
            System.out.println(eachOption.getText());
        }

        // Verify the dropdown has Option 2
        boolean isOption2Exist = false;

        for (WebElement eachOption : optionList){
            if (eachOption.getText().equals("Option 2")){
                isOption2Exist = true;
            }
        }
        // System.out.println("Option2 is found? " + isOption2Exist);

        // Assertion
        assertTrue(isOption2Exist);


    }

    @Test
    public void getFirstSelectedOptionTest(){
        WebElement firstDropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(firstDropDown);

        String firstSelectedOption =  select.getFirstSelectedOption().getText();
        System.out.println("firstSelectedOption = " + firstSelectedOption);

        // Lets select a different option
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());

        // Select any other
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());


        // Find the number of options available in the dropdown
        int numOfOptions = select.getOptions().size();
        System.out.println("numOfOptions = " + numOfOptions);

        // Assertion
        assertEquals(3, numOfOptions , "Expected is not equal to actual number of options");

    }

    /*
DropDown Interview Questions:
    - What is dropdown?
          Dropdown is a webElement. It has a list of options.
    - How do you handle dropdown? (What do you do to automate dropdown?)
          Dropdowns are created using SELECT class. We first locate the dropdown
          element, then use select class to interact with the dropdown elements.
    - How do you select dropdown elements?
          We actually have 3 ways to select a dropdown (by index, value, visibleText)

 */

}
