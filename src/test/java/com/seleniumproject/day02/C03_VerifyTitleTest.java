package com.seleniumproject.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_VerifyTitleTest {
    public static void main(String[] args) {

        // We will only use latest way of driver object creation
        WebDriver driver = new ChromeDriver();

        // Maximise the window
        driver.manage().window().maximize();

        // Go to amazon page
        driver.get("https://www.amazon.com");

        // refresh the page
        driver.navigate().refresh();

        // Get the title
        String amazonTitle = driver.getTitle();
        System.out.println("amazonTitle = " + amazonTitle); // printing the value

        // NOTE: Testing is incomplete without verification

        // Test case 1: Verify that amazon page has a title: Amazon.com. Spend Less. Smile More.
        // Verification ( not for testers)
        System.out.println("======= Test Case 1 ========");

        String expectedAmazonTitle = "Amazon.com. Spend less. Smile more.";

        if (expectedAmazonTitle.equals(amazonTitle)){
            System.out.println("Test passed!");
        }else {
            System.out.println("Test failed!");
        }

        // Test case 2: Verify that amazon page has url = https://www.amazon.com

        System.out.println("======= Test Case 2 ========");
        String expectedUrl = "https://www.amazon.com";

        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Test passed!");
        }else {
            System.out.println("Test failed!");
        }

        // Test case 3: Verify that the source code contains a word "Registry"
        System.out.println("======= Test Case 3 ========");
        String expectedWord = "Registry";
        String pageSource = driver.getPageSource();
        // System.out.println("pageSource = " + pageSource);

        if (pageSource.contains(expectedWord)){
            System.out.println("Test passed!");
        }else {
            System.out.println("Test failed!");
        }

        // Test case 4: window handle
        String amazonHandle = driver.getWindowHandle();
        System.out.println("amazonHandle = " + amazonHandle); // 34CAA4A9C8BC15C82E8DFA49A56A95E8

        // Go to another page
        driver.navigate().to("https://www.facebook.com");
        String facebookWindowHandle = driver.getWindowHandle();
        System.out.println("facebookWindowHandle = " + facebookWindowHandle); // 34CAA4A9C8BC15C82E8DFA49A56A95E8

        /*
         NOTE: Window Handles are unique identifiers that are allocated to every webpage
              Why do we see same window handles for amazon and facebook here?
              Because we are opening both pages on the same tab.

              When we switch to different and then open the new window/page, then we will see unique identifier
         */

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.facebook.com");
        String facebookWindowHandle2 = driver.getWindowHandle();
        System.out.println("facebookWindowHandle2 = " + facebookWindowHandle2);

        // Close the window
         driver.close();



    }
}
