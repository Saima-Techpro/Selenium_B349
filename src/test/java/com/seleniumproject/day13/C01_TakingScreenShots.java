package com.seleniumproject.day13;

import com.utils.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TakingScreenShots extends TestBase{

    @Test
    public void takingScreenShots () throws IOException {
        // Go to https://www.techproeducation.com/
        driver.get("https://www.techproeducation.com/");

        // Locate the Logo
        WebElement logo = driver.findElement(By.xpath("(//a[@class='logo-text'])[1]"));

        //1. Take Screenshot of entire page
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //2. Create a name of this image in a dynamic way that it will not be over-written by the next test run
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        System.out.println("now = " + now);

        // String path = System.getProperty("user.dir") + "path of the folder to save screenshots" +now+"image.png";
        System.out.println(System.getProperty("user.dir"));
        String path = System.getProperty("user.dir") + "/test-output/Screenshot/" +now+"image.png";


        // Save the image in this path
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        NOTE: This test method is taking screenshot of the entire page
        // If we want to take screenshot of a specific element, we need to pass that element in image file

        //1. Take Screenshot of a specific element
        File logoImage = logo.getScreenshotAs(OutputType.FILE);
        String path1 = System.getProperty("user.dir") + "/test-output/ElementsScreenshot/" +now+"image.png";

        // Save the image
        FileUtils.copyFile(logoImage, new File(path1));



    }
}
