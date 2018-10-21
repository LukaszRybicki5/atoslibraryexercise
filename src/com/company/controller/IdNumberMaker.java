package com.company.controller;

import com.company.database.ListOfBooks;
import com.company.model.Book;

import java.util.List;

/*
Tworzymy unikalne 4-cyfrowe Id
 */
public class IdNumberMaker {

    int Id;

    public int getRandomAccountNumber() {
        ListOfBooks listOfBooks = new ListOfBooks();
        List<Book> listToVerify = listOfBooks.showListOfBooks();
        Id = (int) (Math.random() * 10000);

        for (Book book : listToVerify) {
            if ((Id == book.getId()) || (Id < 1000)) {
                return getRandomAccountNumber();
            }
        }
        return Id;
    }
}
