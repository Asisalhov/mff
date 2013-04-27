package com.myFootballFacts.servlets;

import com.myFootballFacts.dto.League;
import com.myFootballFacts.dto.Player;
import com.myFootballFacts.dto.Team;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.json.simple.*;

/**
 * Created with IntelliJ IDEA.
 * User: Asi
 * Date: 16/03/13
 * Time: 10:21
 */
public class GetSquadNumbers extends HttpServlet implements ServletContextAttributeListener {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashSet<League> leagues = (HashSet<League>) getServletContext().getAttribute("leagues");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String reqTeam = request.getParameter("Team");
        if (reqTeam == null || reqTeam.equals("")) {
            JSONArray teamListJson = new JSONArray();
            for (League league : leagues) {
                HashSet<Team> teams = league.getTeams();
                for (Team team : teams) {
                    teamListJson.add(team.getName());
                }
            }
            out.write(teamListJson.toJSONString());
            out.flush();
            return;
        }

        // out.write("Hello\n\nWhatzzzup?");
        for (League league : leagues) {
            HashSet<Team> teams = league.getTeams();
            for (Team team : teams) {
                if (team.getName().equalsIgnoreCase(reqTeam)) {
                    out.write(team.toJsonString());
                }
            }
        }

        out.flush();

    }


    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
