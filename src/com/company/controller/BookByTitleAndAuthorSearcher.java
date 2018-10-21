package com.company.controller;

import com.company.database.ListOfBooks;
import com.company.model.Book;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
Proste wyszukiwanie książki według tytułu lub autora
z uwagi na możliwe różne wielkości liter użyto funkcji .toLowerCase()
 */
public class BookByTitleAndAuthorSearcher {

    public void searchBookByTitle() {
        try {
            ListOfBooks listOfBooks = new ListOfBooks();
            List<Book> booksByTitle = listOfBooks.showListOfBooks();
            System.out.println("Podaj tytuł książki:");

            Scanner input = new Scanner(System.in);
            String phrase = input.nextLine().toLowerCase();
            for (Book book : booksByTitle) {
                if (book.getTitle().toLowerCase().equals(phrase)) {
                    System.out.println(
                            "Tytuł: " + book.getTitle() +
                                    ", Autor: " + book.getAuthor() +
                                    ", Rok wydania: " + book.getYear() +
                                    ", Id: " + book.getId() + "."
                    );
                }
            }
            System.out.println("Zakończono wyszukiwanie zapytania.");
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono zły format danych.");
        }
    }

    public void searchBookBytAuthor() {
        try {
            ListOfBooks listOfBooks = new ListOfBooks();
            List<Book> booksByTitle = listOfBooks.showListOfBooks();
            System.out.println("Podaj tytuł książki:");
            Scanner input = new Scanner(System.in);
            String phrase = input.nextLine().toLowerCase();

            for (Book book : booksByTitle) {
                if (book.getAuthor().toLowerCase().equals(phrase)) {
                    System.out.println(
                            "Tytuł: " + book.getTitle() +
                                    ", Autor: " + book.getAuthor() +
                                    ", Rok wydania: " + book.getYear() +
                                    ", Id: " + book.getId() + "."
                    );
                }
            }
            System.out.println("Zakończono wyszukiwanie zapytania.");
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono zły format danych.");
        }
    }
}
