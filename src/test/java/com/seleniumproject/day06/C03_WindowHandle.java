package com.seleniumproject.day06;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class C03_WindowHandle extends TestBase {
    @Test
    public void windowTest() throws InterruptedException {

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
        Thread.sleep(3000);
        assertEquals("New Window", driver.getTitle());

        // If the driver needs to go back and forth again and again, we should get the handle of the new window and save it
        // so we don't have to use getWindowHandles() method again and again.
        String window2Handle = driver.getWindowHandle();
        System.out.println("window2Handle = " + window2Handle);

        // Can we switch back to window 1?
        driver.switchTo().window(window1Handle);
        assertEquals("The Internet", driver.getTitle());
        Thread.sleep(3000);

        // Can we switch back to window 2?
        driver.switchTo().window(window2Handle);
        assertEquals("New Window" , driver.getTitle());
        assertTrue(driver.getCurrentUrl().contains("new"));
        Thread.sleep(3000);


    }
}
