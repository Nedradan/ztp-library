package com.example.lab1.appServlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getServlet", value = "/second-servlet")
public class SecondServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Drugi servlet Janka ";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "wprowadzony test_parameter=" + request.getParameter("test_parameter") + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}