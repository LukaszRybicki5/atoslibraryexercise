package com.company.database;

import com.company.model.Book;
import com.company.model.User;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ListOfBooks {

    private static ArrayList<Book> booksInLibrary = new ArrayList<>();

    public void addBookToList(Book book) {
        booksInLibrary.add(book);
    }

    public ArrayList showListOfBooks() {
        return booksInLibrary;
    }

    public void removeBookFromList(int Id) {
        if (booksInLibrary.isEmpty()) {
            System.out.println("W bibliotece nie ma książek.");
        }
        for (Book book : booksInLibrary) {
            if (book.getId() == Id) {
                if (book.isFreeToLend() == true) {
                    booksInLibrary.remove(book);
                    System.out.println("Usunięto książkę z listy");
                    break;
                }else{
                    System.out.println("Podano złe Id.");
                }
            }
        }
    }

    public void changeStatusToLend(int Id) {
    try {
        if (booksInLibrary.isEmpty()) {
            System.out.println("W bibliotece nie ma książek.");
        }
        User user = new User();
        for (Book book : booksInLibrary) {
            if ((book.getId() == Id) && (book.isFreeToLend() == false)) {
                System.out.println("Książka została już wypożyczona.");
                break;
            }
            if ((book.getId() == Id) && (book.isFreeToLend() == true)) {
                book.setFreeToLend(false);
                user.getMyBooks().add(book);
                System.out.println("Książka została wypożyczona na twoje konto.");
                break;
            }

        }
        }catch(InputMismatchException e){
        System.out.println("Wprowadzono zły format danych");
        }
    }
    public void showDetailsOfBooks() {
        if (booksInLibrary.isEmpty() == true) {
            System.out.println("W bibliotece nie ma książek.");
        } else
            System.out.println("Oto lista książek w bibliotece:");
        for (Book book : booksInLibrary) {
            System.out.println(
                    "Tytuł: " + book.getTitle() +
                            ", Autor: " + book.getAuthor() +
                            ", Rok wydania: " + book.getYear() +
                            ", Id: " + book.getId() + "."
            );
        }
    }
}
