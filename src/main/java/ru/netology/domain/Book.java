package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    private String author;
    private String bookName;


    public Book() {
        super();
    }

    public Book(int id, int price, String author, String bookName) {
        super(id, price);
        this.author = author;
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}