package com.myFootballFacts.dto;


import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Asi
 * Date: 16/03/13
 * Time: 10:32
 */
public class Team {

    String league ;
    String name;
    HashSet<HashMap<Integer,Player>> year;


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
                && !(year != null ? !year.equals(team.year) : team.year != null);

    }

    @Override
    public int hashCode() {
        int result = league != null ? league.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
