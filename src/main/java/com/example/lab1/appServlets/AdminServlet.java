package com.example.lab1.appServlets;

import com.example.lab1.generalClasses.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    ArrayList<Book> books;
    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        books = (ArrayList<Book>) context.getAttribute("books");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            boolean loggedFlag = (boolean) request.getSession().getAttribute("loggedFlag");
            boolean adminFlag = (boolean) request.getSession().getAttribute("adminFlag");
            if (loggedFlag && adminFlag) {
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html lang=\"en\">");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<title>Ekran glowny biblioteki</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<center><H1>Ksiazki</H1></center>");
                out.println("<table>\n" +
                        "<tr>\n" +
                        "<th style=\"width:5%;\"><center>Tytul</center</th>\n" +
                        "<th style=\"width:5%;\"><center>Autor</center</th>\n" +
                        "<th style=\"width:5%;\"><center>Rok wydania</center></th>\n" +
                        "</tr>\n");
                for (Book book : books) {
                    out.println(book.toString());
                }
                out.println("</table>");
                out.println("</br>");
                out.println("</br>");
                out.println("<table>\n" +
                        "<tr>\n" +
                        "<th style=\"width:20%;\"><center><button><a href=\"AddBookServlet\">Dodaj nową ksiazke!</a></button></center>\n" +
                        "<th style=\"width:20%;\"><center><button><a href=\"DeleteBookServlet\">Usun ksiazke!</a></button></center>\n" +
                        "</tr>\n");
                out.println("</table>");
                out.println("</br>");
                out.println("</br>");
                out.println("<center><button><a href=\"LogoutServlet\">Wyloguj!</a></button></center>");
                out.println("</body>");
                out.println("</html>");
            } else {
                response.sendRedirect("WelcomeServlet");
            }
        } catch(Exception e){
            response.sendRedirect("LoginServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
