package com.seleniumproject.day09;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    /*
Store the path of the file as string and open the file
Open the workbook
Open the first worksheet
Go to the first row
Write and save the workbook
Create a cell on the 3rd column (2nd index) on the first row
Write “POPULATION” on that cell
Create a cell on the 2nd row 3rd cell(index2), and write 150000
Create a cell on the 3rd row 3rd cell(index2), and write 250000
Create a cell on the 4th row 3rd cell(index2), and write 54000
Close the file
Close the workbook
     */


    @Test
    public void writeExcel() throws IOException {

        // Store the path of the file
        String path = "resources/Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheet("Sheet1");

        Row row1 = sheet1.getRow(0);

        // Write "POPULATION" in 3rd column
        Cell cell3 = row1.createCell(2);

        // To write
        cell3.setCellValue("POPULATION");


        // To see if the value exists
        String cell3Value = row1.getCell(2).toString();
        System.out.println("cell3Value = " + cell3Value);


//        Create a cell on the 2nd row 3rd cell(index2), and write 150000
        Row row2 = sheet1.getRow(1);
        row2.createCell(2).setCellValue(150000);

//        Create a cell on the 3rd row 3rd cell(index2), and write 250000
        sheet1.getRow(2).createCell(2).setCellValue(250000);
//        Create a cell on the 4th row 3rd cell(index2), and write 54000
        sheet1.getRow(3).createCell(2).setCellValue(54000);


        // MANDATORY STEP: To see values added on to Excel file
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

    }
}
