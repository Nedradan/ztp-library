package com.example.lab1.appServlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("Password");;
        String login = request.getParameter("Username");;
        PrintWriter out = response.getWriter();
        out.println(login);
        out.println(password);

        if(password.equals("admin")){
            out.println("Logowanie admina udane");
        } else {
            out.println("Próba logowania nieudana");
        }
    }
}
