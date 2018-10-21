package com.company.controller;

import com.company.database.ListOfBooks;
import com.company.model.Book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Wyszukiwanie książek według autora lub tytułu oparte na wyrażeniach regularnych
*/
public class BookSearcher {

    public void lookingForBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj frazę do wyszukiwania:");
        String phrase = input.nextLine();
        searchingInLibrary(phrase);
            }

    private void searchingInLibrary(String phrase) {
        try {
            System.out.println("Pierwsze podejscie");
            ListOfBooks listOfBooks = new ListOfBooks();
            ArrayList<Book> listToSearch = listOfBooks.showListOfBooks();

            StringBuilder stringBuilder = new StringBuilder(".*");
            String REGEX = stringBuilder.append(phrase.toLowerCase()).append(stringBuilder).append(".*").toString();
            Pattern p1 = Pattern.compile(REGEX);
            Pattern p2 = Pattern.compile(REGEX);

            int foundBook = 0;
            for (Book book : listToSearch) {

                String INPUTAUTHOR_1 = book.getAuthor().toLowerCase();
                String INPUTTITLE_1 = book.getTitle().toLowerCase();

                Matcher matcherAuthor = p1.matcher(INPUTAUTHOR_1);
                Matcher matcherTitle = p2.matcher(INPUTTITLE_1);

                if ((matcherAuthor.find()) || (matcherTitle.find())) {
                    System.out.println(
                            "Tytuł: " + book.getTitle() +
                                    ", Autor: " + book.getAuthor() +
                                    ", Rok wydania: " + book.getYear() +
                                    ", Id: " + book.getId()
                    );
                    foundBook++;
                }
            }

            //Jeśli wszystkie ksiązki nie nadają się do wyświetlenie próbujemy drugiej metody
            if (foundBook < listToSearch.size()) {
                int amountOfLetterInPhrase = phrase.length();

                System.out.println("Drugie podejscie");
                for (int i = 0; i < amountOfLetterInPhrase; i++) {
                    StringBuilder stringBuilder2 = new StringBuilder(".*");

                    String REGEX_2 = stringBuilder2.append(phrase.toLowerCase().substring(i, amountOfLetterInPhrase)).append(stringBuilder).append(".*").toString();
                    Pattern p3 = Pattern.compile(REGEX_2);
                    Pattern p4 = Pattern.compile(REGEX_2);

                    for (Book book : listToSearch) {

                        String INPUTAUTHOR_2 = book.getAuthor().toLowerCase();
                        String INPUTTITLE_2 = book.getTitle().toLowerCase();

                        Matcher matcherAuthor = p3.matcher(INPUTAUTHOR_2);
                        Matcher matcherTitle = p4.matcher(INPUTTITLE_2);

                        if ((matcherAuthor.find()) || (matcherTitle.find())) {
                            System.out.println(
                                    "Tytuł: " + book.getTitle() +
                                            ", Autor: " + book.getAuthor() +
                                            ", Rok wydania: " + book.getYear() +
                                            ", Id: " + book.getId()
                            );
                            foundBook++;
                        }
                    }
                }
            }

            System.out.println("Zakończono wyszukiwanie.");
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            System.out.println("Wprowadzono zły format danych.");
        }
    }
}