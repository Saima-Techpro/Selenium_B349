package com.seleniumproject.day11;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C01_FileExists {

    // Create a file on desktop
    // Copy the path of the file
    // Assert if the file exists on that path

    @Test
    public void isFileExist(){
        // Path of file: /Users/saima/Desktop/flower.jpeg

        String userDir = System.getProperty("user.dir"); // returns the path of the current folder ; dir stands for directory
        System.out.println("userDir = " + userDir);


        String userHome = System.getProperty("user.home"); // returns the path of the user's home (computer) dynamically
        System.out.println("userHome = " + userHome);

        // Verify if the file exists
        String pathOfFile = userHome + "/Desktop/flower.jpeg";
        System.out.println("pathOfFile = " + pathOfFile); // /Users/saima/Desktop/flower.jpeg

        boolean isExists = Files.exists(Paths.get(pathOfFile));
        System.out.println("isExists = " + isExists);
        assertTrue(isExists);

        // OR in short way:
        assertTrue(Files.exists(Paths.get(pathOfFile)));


    }
}

