package com.seleniumproject.day06;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowTest(){

        driver.get("https://the-internet.herokuapp.com/windows");

        // Verify the header
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        assertEquals("Opening a new window", window1Text);

        // Verify the title of the page
        assertEquals("The Internet" , driver.getTitle());

        // Get the window handle => unique ID given to each page
        String window1Handle = driver.getWindowHandle(); // Returns the ID of the current window
        System.out.println("window1Handle = " + window1Handle);

        // Click on the 'Click Here' link
        driver.findElement(By.linkText("Click Here")).click();

        // When we click, new window opens. But the driver is still in the first window
        // We need to switch to the new window for driver to see the elements on the new window
        // driver.switchTo().window(id of new window);
        // But driver can switch to a new  window only with an ID of the new window

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("allWindowHandles = " + allWindowHandles);

        for (String eachHandle : allWindowHandles){ // looping through all handles one by one
            if (! eachHandle .equals(window1Handle)){ // if it is not equal to window 1, it means it should be the handle of window 2
                driver.switchTo().window(eachHandle); // so switch to window 2
            }
        }

        // Driver is now switched to the window 2



    }
}
