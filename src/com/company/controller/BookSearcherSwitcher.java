package com.company.controller;

import java.util.Scanner;

import static java.lang.System.exit;

/*
Wyszukiwanie pozycji z uzyciem wyrażeń regularnych
 */
public class BookSearcherSwitcher {

    public void lookingForBook() {

        BookByTitleAndAuthorSearcher bookByTitleAndAuthorSearcher = new BookByTitleAndAuthorSearcher();
        BookSearcher bookSearcher = new BookSearcher();
        boolean optionFlag = true;

        while (optionFlag) {
            System.out.println("Podaj sposób wyszukiwania:" +
                    "\na) Wyszukaj książke według autora" +
                    "\nb) Wyszukaj książke według tytułu" +
                    "\nc) Nieostre wyszukiwanie frazy" +
                    "\nx) Zakończ działanie wyszukiwarki"
            );
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            switch (choice) {
                case "a":
                    bookByTitleAndAuthorSearcher.searchBookBytAuthor();
                    break;
                case "b":
                    bookByTitleAndAuthorSearcher.searchBookByTitle();
                    break;
                case "c":
                    bookSearcher.lookingForBook();
                    break;
                case "x":
                    optionFlag = false;
                    break;
                default:
                    System.out.println("\tBłąd!!!\nWybierz opcje " +
                            "(wpisz małą literę a lub b w konsolę).");
                    break;
            }
        }
    }
}