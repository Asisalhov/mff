package com.myFootballFacts.dto;


import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Asi
 * Date: 16/03/13
 * Time: 10:32
 */
public class Team {

    String league ;
    String name;
    HashMap years;

    public HashMap getYears() {
        return years;
    }

    public void setYears(HashMap years) {
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
}
