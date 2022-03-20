package com.example.lab1.appServlets;

import com.example.lab1.generalClasses.Book;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AddBookServlet", value = "/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    ArrayList<Book> books;
    ServletContext context;
    @Override
    public void init() throws ServletException {
        context = getServletContext();
        books = (ArrayList<Book>) context.getAttribute("books");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String title = request.getParameter("addTitle");
            String author = request.getParameter("addAuthor");
            int year = Integer.parseInt(request.getParameter("addYear"));
            Book addedBook=new Book(title,author,year);
            books.add(addedBook);
            context.setAttribute("books", books);
            response.sendRedirect("AdminServlet");
        }
        catch(Exception e) {
            e.printStackTrace();
            response.sendRedirect("AdminServlet");
        }
    }
}
