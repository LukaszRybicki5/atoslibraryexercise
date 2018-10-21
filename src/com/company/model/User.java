package com.company.model;

import java.util.ArrayList;
import java.util.InputMismatchException;

/*
Klasa czytelnika czyli osoby obsługującej konsolę
 */
public class User {

    private static ArrayList<Book> myBooks = new ArrayList<>();

    public ArrayList<Book> getMyBooks() {
        return myBooks;
    }

    public void removeBookFromUserList(int Id) {
        try {
            for (Book book : myBooks) {
                if (book.getId() == Id) {
                    myBooks.remove(book);
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono zły format danych.");
        }
    }
}
