package com.myFootballFacts;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String team = request.getParameter("Team");
        Config config = (Config) getServletContext().getAttribute("leagues");

        data = get



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
