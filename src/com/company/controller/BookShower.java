package com.company.controller;

import com.company.database.ListOfBooks;
import com.company.model.Book;
import com.company.model.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
Pokazujemy elemety księgozbioru
 */
public class BookShower {

    public void showingBooksFromLibrary() {
        ListOfBooks listOfBooks = new ListOfBooks();
        listOfBooks.showDetailsOfBooks();
    }

    public void showingBooksFromYourAccount() {
        boolean optionFlag = true;
        while (optionFlag) {
            User user = new User();
            List<Book> list = user.getMyBooks();
            if (list.isEmpty() == true) {
                System.out.println("Nie wypożyczyłeś książek.");
                break;
            }

            System.out.println("Oto lista książek w które wypozyczyłeś:");
            for (Book book : list) {
                System.out.println(
                        "Tytuł: " + book.getTitle() +
                                ", Autor: " + book.getAuthor() +
                                ", Rok wydania: " + book.getYear() +
                                ", Id: " + book.getId() + "."
                );
            }
            optionFlag = false;
        }
    }

    public void showingBooksById() {
        try {
            Scanner input = new Scanner(System.in);
            ListOfBooks listOfBooks = new ListOfBooks();
            List<Book> listOfBooksLookinfForID = listOfBooks.showListOfBooks();
            if (listOfBooksLookinfForID.isEmpty() == true) {
                System.out.println("Nie ma książek w bibliotece.");
            } else
                System.out.println("Podaj Id książki którą chcesz sprawdzić.");
            int Id = input.nextInt();
            for (Book book : listOfBooksLookinfForID) {
                if (book.getId() == Id) {
                    System.out.println(
                            "Tytuł: " + book.getTitle() +
                                    ", Autor: " + book.getAuthor() +
                                    ", Rok wydania: " + book.getYear()
                    );
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono niepoprawny format danych.");
        }
    }
}