package com.myFootballFacts.dto;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Asi
 * Date: 16/03/13
 * Time: 11:09
 */
public class League {
    String leagueName;
    HashSet <Team> teams;

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public HashSet<Team> getTeams() {
        return teams;
    }

    public void setTeams(HashSet<Team> teams) {
        this.teams = teams;
    }


}
