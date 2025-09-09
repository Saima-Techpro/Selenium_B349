package com.seleniumproject.day06;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class C02_IFrame  extends TestBase {

    /*
      Summary notes:
    - Iframe is used to add a page within a page e.g. maps, videos, scrollbars etc.
    - so driver must switch to iframe first to see the elements in the iframe
    - syntax ==> driver.switchTo().frame();
    - we can use 3 ways to get to the required iframe =>  ("by using id/name, index, or web-element");
    - how to come out of the iframe?  driver.switchTo().parentFrame() OR defaultContent()
    - parentFrame() always switch one level up
    - defaultContent() switches to the highest level


    Interview question:

        What might be the reason(s) for your test case to fail?
           - There might be wait problem; the page may be very slow to load
              Internet might be slow. (Solution: Put some explicit wait in selenium)
           -  Locator might be incorrect.
              (Solution: Double check locator and fix it if needed)
           - Data issue. Typo in our expected values.
              (Solution: If there is any documentation issue, we can talk to BA to fix the document
                         and then we can use correct expected values)
           - Maybe there is an iframe on the page
              (Solution: We first need to switch to the frame)
           - Maybe there is an alert on the page
              (Solution: We first need to handle the alert by accepting or dismissing)
           - Maybe the page opens in a new tab or window
              (Solution: We first need to switch the target window)
           - It may be a real bug that is caused by the latest codes.
              (Solution: We discuss the issue with the team then raise a bug ticket if needed)

     */

    //    Given Go to https://testpages.herokuapp.com/styled/frames/frames-test.html
    //    Then Assert that "Left List Item 29" is the last element in the "Left"
    //    And Assert that "Middle List Item 39" is the last element in the "Middle"


    @Test
    public void iframeTest(){
        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
        // String lastElementText = driver.findElement(By.cssSelector("#left29")).getText();

//        WebElement lastElement = driver.findElement(By.cssSelector("#left29"));
//        WebElement lastElement = driver.findElement(By.id("left29"));

         /*
         NOTE 1: "Left List Item 29" is INSIDE an iframe. So we need to switch the driver to this iframe FIRST.

         There are 3 ways to switch to an iframe:
         1. index   2. id/name    3. webElement

         driver.switchTo().frame(1); // can change
         driver.switchTo().frame("left"); // recommended
         driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='left']"))); // recommended

          */

        driver.switchTo().frame("left"); // recommended
        // DRIVER IS INSIDE THE IFRAME NOW
         WebElement lastElement = driver.findElement(By.xpath("//li[@id='left29']"));

        String lastElementText = lastElement.getText();
        System.out.println("lastElementText = " + lastElementText);

        assertTrue(lastElementText.equals("Left List Item 29"));

        //    And Assert that "Middle List Item 39" is the last element in the "Middle"
        // driver is still inside left frame at this point
        // To go to its sibling frame, switch to the parent frame first, then to the child frame
        driver.switchTo().parentFrame(); // will switch to the parent frame and will be able to access all 3 iframes insode
        // OR
        // driver.switchTo().defaultContent(); // will go to the html tag on top of the page

        driver.switchTo().frame("middle");

        String middleFrameLastElement = driver.findElement(By.id("middle39")).getText();
        assertEquals("Middle List Item 39" , middleFrameLastElement);











    }
}
