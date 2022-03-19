package com.example.lab1.appServlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.security.sasl.AuthenticationException;

@WebServlet(name = "UsersLoginServlet", value = "/UsersLoginServlet")
public class UsersLoginServlet extends HttpServlet {

    HashMap<String, String> Users=new HashMap<String, String>();

    @Override
    public void init() throws ServletException {
        super.init();
        Users.put("user1","pass1");
        Users.put("user2","pass2");
        Users.put("user3","pass3");
        Users.put("user4","pass4");
    }

    private boolean checkUser(String login, String password){
        try {
            String pass = Users.get(login);
            return pass.equals(password);
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String password = request.getParameter("Password");
            String login = request.getParameter("Username");
            PrintWriter out = response.getWriter();
            out.println(login);
            out.println(password);
            if (checkUser(login, password)) {
                out.println("Logowanie uzytkownika udane!");
                response.sendRedirect("DashboardServlet");
            } else {
                throw new AuthenticationException();
            }
        }
        catch(Exception e)
        {
            request.getRequestDispatcher("/loginFailed.html").forward(request, response);
        }
    }
}
