package com.myFootballFacts.util;

import com.myFootballFacts.dto.League;

import java.util.HashSet;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Asi
 * Date: 16/03/13
 * Time: 11:16
 */
public class DataFiller {
    public HashSet<League> fillLeaguesData() {
        HashSet<League> leagues = new HashSet<League>();
        ImportExcelSheet importExcelSheet=new ImportExcelSheet();
        Vector dataHolder=importExcelSheet.importSheet("Excel_file.xlsx");


        return leagues;
    }
}
