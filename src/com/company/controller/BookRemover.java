package com.company.controller;

import com.company.database.ListOfBooks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookRemover {

    public void removingBookFromList() throws InputMismatchException {
        try {
            boolean optionFlag = true;
            while (optionFlag) {
                ListOfBooks listOfBooks = new ListOfBooks();
                if (listOfBooks.showListOfBooks().isEmpty()) {
                    System.out.println("Nie ma książek w bibliotece.");
                    break;
                }
                Scanner inputId = new Scanner(System.in);
                System.out.println("Podaj Id książki którą chcesz usunąć:");
                int Id = inputId.nextInt();
                listOfBooks.removeBookFromList(Id);
                optionFlag = false;
            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono zły format danych!!!");
        }
    }
}
