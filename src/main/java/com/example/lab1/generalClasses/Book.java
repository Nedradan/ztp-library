package com.example.lab1.generalClasses;

public class Book {

    protected String title;
    protected String author;
    protected int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(int number){
        this.title = "Książka"+String.valueOf(number);
        this.author = "Autor"+String.valueOf(number);
        this.year = 1999+number;
    }
    
    public String showBook() {
        return "<tr>\n" +
                "   <td>"+title+"</th>\n" +
                "   <td>"+author+"</th>\n" +
                "   <td>"+year+"</th>\n" +
                "</tr>\n";
    }
}
