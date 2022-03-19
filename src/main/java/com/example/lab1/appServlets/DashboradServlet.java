package com.example.lab1.appServlets;

import com.example.lab1.generalClasses.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "DashboradServlet", value = "/DashboradServlet")
public class DashboradServlet extends HttpServlet {

    ArrayList<Book> books;
    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        books = (ArrayList<Book>) context.getAttribute("books");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"pl\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Ekran główny biblioteki</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<H1>Ksiązki</H1>");
        out.println("<table>\n" +
                "  <tr>\n" +
                "    <th>Tytuł</th>\n" +
                "    <th>Autor</th>\n" +
                "    <th>Rok wydania</th>\n" +
                "  </tr>\n");
        for (Book book:
                books) {
            out.println(book.toString());
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
