package com.example.lab1.appServlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.security.sasl.AuthenticationException;
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
        try {
            String password = request.getParameter("Password");
            String login = request.getParameter("Username");

            if (password.equals("admin")) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedFlag", true);
                response.sendRedirect("DashboardServlet");
            } else {
                throw new AuthenticationException();
            }
        } catch(Exception e)
        {
            request.getRequestDispatcher("/loginFailed.html").forward(request, response);
        }
    }
}
