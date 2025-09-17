package com.seleniumproject.day11;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C02_FileDownload extends TestBase {

    /*
Create a class:FileDownload
downloadTest()
In the downloadTest() method, do the following test:
https://the-internet.herokuapp.com/download
Download Rectangle.png  file
Then verify if the file downloaded successfully
 */


    @Test
    public void fileDownLoadTest(){

//        Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

//        Download puppy.jpg or any other  file
        driver.findElement(By.partialLinkText("simple.txt")).click();

        // After clicking, it takes a few milliseconds to download, so we should add some wait
        waitFor(4);

        // Find the path of the file that you just downloaded
        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);

        String filePath = userHome + "/Downloads/simple.txt";
        System.out.println("filePath = " + filePath);


//        Then verify if the file downloaded successfully
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        assertTrue(isDownloaded);

    }
}
