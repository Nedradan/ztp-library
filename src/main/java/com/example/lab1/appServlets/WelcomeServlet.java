package com.example.lab1.appServlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.AuthenticationException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeServlet", value = "/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            boolean loggedFlag = (boolean) request.getSession().getAttribute("loggedFlag");
            boolean adminFlag = (boolean) request.getSession().getAttribute("adminFlag");
            if(loggedFlag == true) {
                if (adminFlag == true){
                    response.sendRedirect("AdminServlet");
                } else {
                    response.sendRedirect("DashboardServlet");
                }
            }
            else {
                throw new AuthenticationException();
            }
        }
        catch(Exception e){
            response.sendRedirect("LoginServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
