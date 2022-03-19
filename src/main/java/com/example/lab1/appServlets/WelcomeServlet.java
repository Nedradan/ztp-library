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
            if(loggedFlag == true) {
                request.getRequestDispatcher("DashboardServlet").forward(request, response);
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
