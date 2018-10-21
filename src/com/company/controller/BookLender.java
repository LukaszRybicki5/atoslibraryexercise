package com.company.controller;

import com.company.database.ListOfBooks;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookLender {

    public void lendingBookById() throws InputMismatchException {
        try {
            System.out.println("Podaj Id ksiązki którą chcesz wypożyczyć:");
            Scanner input = new Scanner(System.in);
            int Id = input.nextInt();

            ListOfBooks listOfBooks = new ListOfBooks();
            listOfBooks.changeStatusToLend(Id);

        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono zły format danych.");
        }
    }
}
