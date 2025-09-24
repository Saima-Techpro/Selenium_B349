package com.practices.practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01_Navigate {
    /*
         Set Driver Path
         Create chrome driver object
         Maximize the window
         Open techproeducation home page https://techproeducation.com/
         Minimize this window
         Navigate to google home page https://www.google.com/
         Maximise the window
         Open https://www.amazon.com as a new tab or new window
         Navigate back to google
         Navigate forward to amazon
         Refresh the page
         Close/Quit the browser
         And last step : print "ALL OK" on console
    */
    public static void main(String[] args) throws InterruptedException {

//        Set Driver Path
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

//        Create chrome driver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Open techproeducation home page https://techproeducation.com/
        Thread.sleep(2000);
        driver.get("https://techproeducation.com/" );

        //        Minimize this window
        driver.manage().window().minimize();

//        Navigate to google home page https://www.google.com/
        Thread.sleep(2000);
        driver.get("https://google.com/");

        //        Maximise the window
//        driver.manage().window().fullscreen();
        driver.manage().window().maximize();

//        Open https://www.amazon.com as a new tab or new window
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com");
        // OR
        // driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.amazon.com");
        Thread.sleep(2000);

//        Navigate back to google
        Thread.sleep(2000);
        driver.navigate().back();

//        Navigate forward to amazon
        Thread.sleep(2000);
        driver.navigate().forward();

//        Refresh the page
        Thread.sleep(2000);
        driver.navigate().refresh();

//        Close/Quit the browser
        Thread.sleep(2000);
        //driver.close();//close() method closes only one current window
        driver.quit();//quit() method closes all windows that was opened in one single driver in a session

//        And last step : print "ALL OK" on console
        System.out.println("ALL OK");

    }
}