package com.company.controller;

import com.company.model.Book;
import com.company.model.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Zwracamy książkę ze zbioru Usera do księgozbioru gdzie zmienia status na  true
 */
public class BookReturner {

    public void returnBook() {
        try {
            boolean optionFlag = true;
            while (optionFlag) {
                User user = new User();
                ArrayList<Book> listOfMyBooks = user.getMyBooks();
                if (listOfMyBooks.isEmpty() == true) {
                    System.out.println("Nie wypożyczyłeś książek.");
                    break;
                }
                System.out.println("Oto lista książek na twoim koncie:");

                for (Book book : listOfMyBooks) {
                    System.out.println(
                            "Tytuł: " + book.getTitle() +
                                    ", Autor: " + book.getAuthor() +
                                    ", Rok wydania: " + book.getYear() +
                                    ", Id: " + book.getId() + "."
                    );
                }

                System.out.println("Podaj Id ksiażki która chcesz oddać:");
                Scanner input = new Scanner(System.in);
                int Id = input.nextInt();

                for (Book book : listOfMyBooks) {
                    if (book.getId() == Id) {
                        book.setFreeToLend(true);
                        listOfMyBooks.remove(book);
                        user.removeBookFromUserList(Id);
                        System.out.println("Podana książka została zwrócona do biblioteki.");
                        optionFlag = false;
                        break;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono zły format danych.");
        }
    }
}



