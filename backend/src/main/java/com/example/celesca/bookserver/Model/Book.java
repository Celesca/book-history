package com.example.celesca.bookserver.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Book {
    private String title;
    private String author;
    private String image;

    public Book(String title, String author, String image) {
        this.title = title;
        this.author = author;
        this.image = image;
    }
}
