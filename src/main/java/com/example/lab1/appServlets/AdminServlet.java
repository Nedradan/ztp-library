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
                PrintWriter output = response.getWriter();
                output.println("<!DOCTYPE html>");
                output.println("<html lang=\"en\">");
                output.println("<head>");
                output.println("<meta charset=\"UTF-8\">");
                output.println("<title>Ekran glowny biblioteki</title>");
                output.println("</head>");
                output.println("<body>");
                output.println("<center><H1>Ksiazki</H1></center>");
                output.println("<table>\n" +
                        "<tr>\n" +
                        "<th style=\"width:5%;\"><center>Tytul</center</th>\n" +
                        "<th style=\"width:5%;\"><center>Autor</center</th>\n" +
                        "<th style=\"width:5%;\"><center>Rok wydania</center></th>\n" +
                        "</tr>\n");
                for (Book book : books) {
                    output.println(book.toString());
                }
                output.println("</table>");
                output.println("</br>");
                output.println("</br>");
                output.println("<center><table>\n" +
                        "<tr>\n" +
                        "<th style=\"width:10%;\"><form action=\"RemoveBookServlet\" method=\"post\">\n" +
                        "    <label for=\"Title\">Tytul:</label>\n" +
                        "    <input type=\"text\" id=\"Title\" name=\"Title\">\n" +
                        "    <input type=\"submit\" value=\"Usun ksiazke!\">\n" +
                        "</form>\n" +
                        "</tr>\n");
                output.println("</table></center>");
                output.println("</br>" +
                        "</br>" +
                        "<center><table>\n" +
                        "<th style=\"width:10%;\"><form action=\"AddBookServlet\" method=\"post\">\n" +
                        "    <label for=\"addTitle\">Tytul:</label>\n" +
                        "    <input type=\"text\" id=\"addTitle\" name=\"addTitle\">\n" +
                        "    </br>" +
                        "    <label for=\"addAuthor\">Autor:</label>\n" +
                        "    <input type=\"text\" id=\"addAuthor\" name=\"addAuthor\">\n" +
                        "    </br>" +
                        "    <label for=\"addYear\">Rok liczbowo:</label>\n" +
                        "    <input type=\"text\" id=\"addYear\" name=\"addYear\">\n" +
                        "    </br>" +
                        "    <input type=\"submit\" value=\"Dodaj ksiazke!\">\n" +
                        "</form>\n" +
                        "</tr>\n");
                output.println("</table></center>");
                output.println("</br>");
                output.println("</br>");
                output.println("<center><button><a href=\"LogoutServlet\">Wyloguj!</a></button></center>");
                output.println("</body>");
                output.println("</html>");
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
