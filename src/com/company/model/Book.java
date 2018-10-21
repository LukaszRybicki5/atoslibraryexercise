package com.company.model;

public class Book {

    private int Id;
    private String Title;
    private String Author;
    private int Year;
    private boolean FreeToLend;

    public Book() {
    }

    public Book(int id, String title, String author, int year, boolean freeToLend) {
        Id = id;
        Title = title;
        Author = author;
        Year = year;
        FreeToLend = freeToLend;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public boolean isFreeToLend() {
        return FreeToLend;
    }

    public void setFreeToLend(boolean freeToLend) {
        FreeToLend = freeToLend;
    }
}
