package com.myFootballFacts.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Asi
 * Date: 16/03/13
 * Time: 11:20
 */
public class ImportExcelSheet {

    private Vector importExcelSheet(String fileName)
    {
        Vector cellVectorHolder = new Vector();
        try
        {
            Workbook workBook = WorkbookFactory.create(new FileInputStream(fileName));
            Sheet sheet = workBook.getSheetAt(0);
            Iterator rowIter = sheet.rowIterator();

            while(rowIter.hasNext())
            {
                XSSFRow row = (XSSFRow) rowIter.next();
                Iterator cellIter = row.cellIterator();
                Vector cellStoreVector=new Vector();

                while(cellIter.hasNext())
                {
                    XSSFCell cell = (XSSFCell) cellIter.next();
                    cellStoreVector.addElement(cell);
                }
                cellVectorHolder.addElement(cellStoreVector);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return cellVectorHolder;
    }
}
