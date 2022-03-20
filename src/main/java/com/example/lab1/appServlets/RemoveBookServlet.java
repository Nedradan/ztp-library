package com.example.lab1.appServlets;

import com.example.lab1.generalClasses.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "RemoveBookServlet", value = "/RemoveBookServlet")
public class RemoveBookServlet extends HttpServlet {
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
            String title = request.getParameter("Title");
            for(int i = 0; i<books.size(); i++) {
                String pomTitle = books.get(i).getBookTitle();
                if(pomTitle.equals(title)){
                    books.remove(i);
                    break;
                }
            }
            context.setAttribute("books", books);
            response.sendRedirect("AdminServlet");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
