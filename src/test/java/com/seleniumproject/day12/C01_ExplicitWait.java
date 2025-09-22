package com.seleniumproject.day12;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class C01_ExplicitWait extends TestBase {
    /*
There are two(or three) main types of DYNAMIC WAITS in Selenium:

1.Implicit wait: This is a global timeout for all elements on the page-waits. Applies automatically to the
driver whenever driver is used. Throws NO SUCH ELEMENT EXCEPTION if element isn't found in the given time.

2. Explicit wait: This is mostly used for a given condition for specific elements. This is local wait.
   Throws TIME OUT EXCEPTION if element isn't found in the given time.

   *** When used together, Explicit Wait overrides the Implicit Wait. ***

3. There is a third type as well FLUENT WAIT . But it's also considered subset of Explicit Wait because it's so similar.
    Throws TIME OUT EXCEPTION if element isn't found in the given time.

Thread.sleep() is HARD WAIT. It's also called JAVA WAIT.
 */

    @Test
    public void explicitWaitTest(){
        // https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get(" https://the-internet.herokuapp.com/dynamic_loading/1");

        // Click on Start button
        //WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        //WebElement startButton = driver.findElement(By.xpath("//button"));
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();

        // Following assertion fails because IMPLICIT WAIT is not able to handle the wait issue (the green loading bar)
        // This is called SYNCHRONISATION issue.
        // Verify the 'Hello World!' message shows up
        //WebElement successMessage = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        // assertTrue(successMessage.getText().contains("Helle World!"));


        // To handle this, we need EXPLICIT WAIT
        // Solution:EXPLICIT WAIT
        // Step 1: Create WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Step 2: Use this object with the appropriate methods to handle the SYNCHRONISATION issue.

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        System.out.println("successMessage = " + successMessage.getText());

        // Verify the success message is visible
        assertTrue(successMessage.getText().contains("Hello World!"));
        // OR
        assertEquals("Hello World!", successMessage.getText());


    }

    @Test
    public void explicitWaitWithReusable(){
        // https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get(" https://the-internet.herokuapp.com/dynamic_loading/1");
        // Click on Start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();

        // Find element using Reusable method from TestBase =>  waitForVisibility()
        WebElement successMessage = waitForVisibility(By.xpath("//div[@id='finish']//h4"), 15);

        // Verify the success message is visible
        assertEquals("Hello World!", successMessage.getText());
    }
}
