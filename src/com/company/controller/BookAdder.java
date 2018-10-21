package com.company.controller;

import com.company.database.ListOfBooks;
import com.company.model.Book;
import com.company.view.Menu;

import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookAdder {

    public void addingBookToList() throws InputMismatchException {
        try {
            boolean optionFlag = true;
            while (optionFlag) {
                Scanner scanner = new Scanner(System.in);
                Book book = new Book();

                System.out.println("Podaj tytuł książki");
                String title = scanner.nextLine().trim();
                book.setTitle(title);

                System.out.println("Podaj autora książki");
                String author = scanner.nextLine().trim();
                book.setAuthor(author);

                Scanner input = new Scanner(System.in);
                System.out.println("Podaj rok wydania ksiązki");
                int year = input.nextInt();

                if (year > 2018) {
                    System.out.println("Zła data wydania.");
                    break;
                }

                book.setYear(year);
                IdNumberMaker idNumberMaker = new IdNumberMaker();
                book.setId(idNumberMaker.getRandomAccountNumber());
                book.setFreeToLend(true);

                ListOfBooks listOfBooks = new ListOfBooks();
                listOfBooks.addBookToList(book);
                optionFlag = false;
            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono niepoprawny format danych!!!\nPonów próbę!!!");
        }
    }
}

