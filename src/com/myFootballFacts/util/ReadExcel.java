package com.myFootballFacts.util;

/**
 * Created with IntelliJ IDEA.
 * User: Asi
 * Date: 16/03/13
 * Time: 12:33
 */

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public Workbook read() throws IOException {
        File inputWorkbook = new File(inputFile);

        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
           return w;
        } catch (BiffException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null
                ;
    }

    public static void main(String[] args) throws IOException {
        ReadExcel test = new ReadExcel();
        test.setInputFile("C:\\work2\\mff\\excelSheets\\PREMIER LEAGUE SQUAD NUMBERS 1993-94 to 2011-12.xls");
        test.read();
    }

}