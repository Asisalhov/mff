package com.myFootballFacts.dto;


import java.util.HashMap;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

/**
 * Created with IntelliJ IDEA.
 * User: Asi
 * Date: 16/03/13
 * Time: 10:32
 */
public class Team {

    String league ;
    String name;
    HashMap<String, HashMap<Integer, Player>>  years;

    public HashMap<String, HashMap<Integer, Player>>  getYears() {
        return years;
    }

    public void setYears(HashMap<String, HashMap<Integer, Player>> years) {
        this.years = years;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;

        Team team = (Team) o;

        return !(league != null ? !league.equals(team.league) : team.league != null)
                && !(name != null ? !name.equals(team.name) : team.name != null)
                && !(years != null ? !years.equals(team.years) : team.years != null);

    }

    @Override
    public int hashCode() {
        int result = league != null ? league.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (years != null ? years.hashCode() : 0);
        return result;
    }


    public String toJsonString() {
        JSONArray columns = new JSONArray();

        HashMap<String, HashMap<Integer, Player>> years = this.getYears();

        columns.addAll(years.keySet());
        for (String year : years.keySet()) {
            HashMap<Integer, Player> payersYear = years.get(year);
            JSONArray rows = new JSONArray();
            for (Integer number:payersYear.keySet()){
                Player player = payersYear.get(number);
                if (player==null) continue;
                String name = player.getFullName();
                rows.add(number + ":" + name);
                //out.write("row: " + rows.toJSONString());

            }
            // out.flush();
            columns.add(rows);
        }
        return JSONValue.toJSONString(columns);
    }
}
