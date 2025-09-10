package com.seleniumproject.day07;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

import static org.junit.jupiter.api.Assertions.*;

public class C01_WindowHandle extends TestBase {

       /*
   -- Open 3 new widows and verify their titles --
    Given
        Open "https://www.techproeducation.com" on Window 1
    When
        Get the title of the page
    Then
        Verify that title contains "Techpro Education"
    When
        Open "https://www.amazon.com" on a NEW Window 2
    And
        Get the title of the page
    Then
        Verify that title contains "Amazon"
    When
        Open "https://www.linkedin.com" on a NEW Window 3
    And
        Get the title of the page
    Then
        Verify that title contains "LinkedIn"
    When
        Switch back to Techpro
    And
        Switch back to Amazon
    And
        Switch back to Linkedin
*/

    @Test
    public void newWindowTest(){

        // Open "https://www.techproeducation.com" on Window 1
        driver.get("https://www.techproeducation.com");
        // Get the title of the page
        String techProTitle = driver.getTitle();
        System.out.println("techProTitle = " + techProTitle);
        // Verify that title contains "Techpro Education"
        assertTrue(techProTitle.contains("TechPro Education"));

        // While driver is here, get its window handle
        String techProWindowHandle = driver.getWindowHandle();
        System.out.println("techProWindowHandle = " + techProWindowHandle);

        // Open "https://www.amazon.com" on a NEW Window 2
        driver.switchTo().newWindow(WindowType.WINDOW); // opens a new window
        driver.get("https://www.amazon.com");

        // Get the title of the page
        String amazonTitle = driver.getTitle();
        System.out.println("amazonTitle = " + amazonTitle);

        // Verify that title contains "Amazon"
        assertTrue(amazonTitle.contains("Amazon"));

        // While driver is here, get its window handle
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("amazonWindowHandle = " + amazonWindowHandle);

        // Open "https://www.linkedin.com" on a NEW Window 3
        driver.switchTo().newWindow(WindowType.WINDOW); // Opens another window
        driver.get("https://www.linkedin.com");

        // Get the title of the page
        String linkedInTitle =driver.getTitle();
        System.out.println("linkedInTitle = " + linkedInTitle);

        // Verify that title contains "LinkedIn"
        assertTrue(linkedInTitle.contains("LinkedIn"));

        // While driver is here, get its window handle
        String linkedInHandle = driver.getWindowHandle();
        System.out.println("linkedInHandle = " + linkedInHandle);

        // Switch back to Techpro
        driver.switchTo().window(techProWindowHandle);

        // Switch back to Amazon
        driver.switchTo().window(amazonWindowHandle);

        // Switch back to Linkedin
        driver.switchTo().window(linkedInHandle);

    }

          /*
   -- Open 3 new tabs and verify their titles --
    Given
        Open "https://www.techproeducation.com" on Tab 1
    When
        Get the title of the page
    Then
        Verify that title contains "Techpro Education"
    When
        Open "https://www.amazon.com" on a NEW Tab 2
    And
        Get the title of the page
    Then
        Verify that title contains "Amazon"
    When
        Open "https://www.linkedin.com" on a NEW Tab 3
    And
        Get the title of the page
    Then
        Verify that title contains "LinkedIn"
    When
        Switch back to Techpro
    And
        Switch back to Amazon
    And
        Switch back to Linkedin
*/

    @Test
    public void newTabTest(){

        // Open "https://www.techproeducation.com" on Tab 1
        driver.get("https://www.techproeducation.com");
        // Get the title of the page
        String techProTitle = driver.getTitle();
        System.out.println("techProTitle = " + techProTitle);
        // Verify that title contains "Techpro Education"
        assertTrue(techProTitle.contains("TechPro Education"));

        // While driver is here, get its window handle
        String techProWindowHandle = driver.getWindowHandle();
        System.out.println("techProWindowHandle = " + techProWindowHandle);

        // Open "https://www.amazon.com" on a NEW Tab 2
        driver.switchTo().newWindow(WindowType.TAB); // opens a new Tab
        driver.get("https://www.amazon.com");

        // Get the title of the page
        String amazonTitle = driver.getTitle();
        System.out.println("amazonTitle = " + amazonTitle);

        // Verify that title contains "Amazon"
        assertTrue(amazonTitle.contains("Amazon"));

        // While driver is here, get its window handle
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println("amazonWindowHandle = " + amazonWindowHandle);

        // Open "https://www.linkedin.com" on a NEW Tab 3
        driver.switchTo().newWindow(WindowType.TAB); // Opens another Tab
        driver.get("https://www.linkedin.com");

        // Get the title of the page
        String linkedInTitle =driver.getTitle();
        System.out.println("linkedInTitle = " + linkedInTitle);

        // Verify that title contains "LinkedIn"
        assertTrue(linkedInTitle.contains("LinkedIn"));

        // While driver is here, get its window handle
        String linkedInHandle = driver.getWindowHandle();
        System.out.println("linkedInHandle = " + linkedInHandle);

        // Switch back to Techpro
        driver.switchTo().window(techProWindowHandle);

        // Switch back to Amazon
        driver.switchTo().window(amazonWindowHandle);

        // Switch back to Linkedin
        driver.switchTo().window(linkedInHandle);

    }

}
