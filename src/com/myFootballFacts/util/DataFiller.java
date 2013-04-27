package com.myFootballFacts.util;

import com.myFootballFacts.dto.League;
import com.myFootballFacts.dto.Player;
import com.myFootballFacts.dto.Team;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Asi
 * Date: 16/03/13
 * Time: 11:16
 */
public class DataFiller {
    public HashSet<League> fillLeaguesData( ServletContext context) throws IOException {
        HashSet<League> leagues = new HashSet<League>();

        ReadExcel readExcel = new ReadExcel();

        readExcel.setInputFile(context.getRealPath ("/WEB-INF/excelSheets/PREMIER LEAGUE SQUAD NUMBERS 1993-94 to 2011-12.xls"));
            Workbook workbook = readExcel.read();
            League league = parseExcel(workbook) ;
            leagues.add(league);


        return leagues;
    }

    public static void main(String[] args) throws IOException {
        DataFiller df = new DataFiller();
      //  HashSet<League> data = df.fillLeaguesData();
     //   System.out.println("hello banana" + data.toString());
    }


    private League parseExcel(Workbook worksheet){
        // Get the first sheet
        League league = new League("PREMIER LEAGUE");
        HashSet <Team> teams = new HashSet<Team>();

        Sheet[] sheets = worksheet.getSheets();
        Team team;
        for (Sheet sheet : sheets) {  //sheet holds a team
            team = new Team();
            team.setName(sheet.getName());
            HashMap<String, HashMap<Integer, Player>> years = new HashMap<String, HashMap<Integer, Player>>();
            String yearTitle;

            for (int j = 3; j < sheet.getColumns(); j++) {     // for every year entry
                yearTitle=sheet.getCell(j,2).getContents();
                HashMap players = new HashMap();
                for (int i = 2; i < sheet.getRows(); i++) { //for each player
                    Cell cell = sheet.getCell(j, i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) {
                        String[] playerName = cell.getContents().split(" ");
                        Player player;
                        if (playerName.length>1 ){
                                player = new Player(playerName[0],playerName[1]);
                        }else {
                                player = new Player(cell.getContents()," ");
                        }
                        players.put(new Integer(i-2),player);

                    }

                    if (type == CellType.NUMBER) {
                        j++;
                    }

                }
                years.put(yearTitle, players);
            }
            team.setYears(years);
            teams.add(team);

        }

        league .setTeams(teams);
        return league;
    }

}
