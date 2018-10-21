package com.company.view;

import com.company.controller.*;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {

    boolean optionFlag = true;

    Scanner input = new Scanner(System.in);

    BookAdder bookAdder = new BookAdder();
    BookRemover bookRemover = new BookRemover();
    BookShower bookShower = new BookShower();
    BookLender bookLender = new BookLender();
    BookReturner bookReturner = new BookReturner();
    BookSearcherSwitcher bookSearcher = new BookSearcherSwitcher();

    public void showingMenu() throws IOException {

        System.out.println("\tWitaj w systemie bibliotecznym!!!" +
                "\nW tym programie możesz zarówno dodawac książki do" +
                "\nzbioru, jak i do swojego konta czytelnika." +
                "\nWypozyczona książka pozostaje w księgozbiorze ale" +
                "\nnie jest możliwe jej ponowne wypożyczenie," +
                "\naż do momentu oddanie jej." +
                "\nDodanie książki o identycznych danych powoduje powstanie" +
                "\nnowej pozycji o nowym Id.\n");
        while (optionFlag) {

            System.out.println("Wybierz co chcesz zrobić:" +
                    "\na) Dodanie książki do księgozbioru" +
                    "\nb) Usunięcie książki wg Id z księgozbioru" +
                    "\nc) Pokazanie listy książek w księgozbiorze" +
                    "\nd) Wypożycz ksiażkę wg Id" +
                    "\ne) Twoje wypożyczone książki" +
                    "\nf) Zwróć wypożyczoną książkę ze swojego konta" +
                    "\ng) Pokaż szczegóły ksiązki wg Id" +
                    "\nh) Wyszukaj książkę w systemie" +
                    "\nx) Zakończ działanie programu"

            );

            String choice = input.nextLine();

            switch (choice) {
                case "a":  //dodajemy nową ksiażkę
                    bookAdder.addingBookToList();
                    break;
                case "b":  //usuwamy książkę wg Id
                    bookRemover.removingBookFromList();
                    break;
                case "c": //pokazanie listy ksiażek
                    bookShower.showingBooksFromLibrary();
                    break;
                case "d": //
                    bookLender.lendingBookById();
                    break;
                case "e":
                    bookShower.showingBooksFromYourAccount();
                    break;
                case "f":
                    bookReturner.returnBook();
                    break;
                case "g":
                    bookShower.showingBooksById();
                    break;
                case "h":
                    bookSearcher.lookingForBook();
                    break;
                case "x":
                    optionFlag = false;
                    exit(0);
                    break;
                default:
                    System.out.println("\tBłąd!!!\nWybierz opcje " +
                            "(wpisz małą literę a lub b w konsolę).");
                    break;
            }
        }
    }
}
