package com.seleniumproject.day11;

import com.utils.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C03_FileUpload extends TestBase {

    @Test
    public void uploadFileTest(){

        // Go to https://testpages.herokuapp.com/styled/file-upload-test.html
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        waitFor(2);

        // Locate choose file button
//        WebElement chooseFileButton = driver.findElement(By.xpath("//*[@id='fileinput']"));
        WebElement chooseFileButton = driver.findElement(By.id("fileinput"));
        chooseFileButton.click();
        waitFor(2);

        // Prepare the path of the file that you need to upload
        String userHome = System.getProperty("user.home");
        String filePath = userHome + "/Downloads/simple.txt";

        // Now upload it to the website
        chooseFileButton.sendKeys(filePath);
        // NOTE: we use sendKeys() to upload file because the input tag on the website has type = file

        // Then we locate the upload button
        WebElement uploadButton = driver.findElement(By.name("upload"));
        uploadButton.click();
        waitFor(2);

        // Verify the upload is successful
        WebElement uploadedFileName = driver.findElement(By.id("uploadedfilename"));

        assertTrue(uploadedFileName.getText().contains("simple.txt"));


    }
}
