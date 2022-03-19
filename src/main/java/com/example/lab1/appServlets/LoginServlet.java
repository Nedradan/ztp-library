package com.example.lab1.appServlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login= request.getParameter("Username");
        String password= request.getParameter("Password");

        RequestDispatcher loginDispatcher;
        if (login.equals("admin")) {
            loginDispatcher = request.getRequestDispatcher("AdminLoginServlet");
        } else{
            loginDispatcher=request.getRequestDispatcher("UsersLoginServlet");
        }
        loginDispatcher.forward(request, response);
    }
}
