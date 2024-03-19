package com.example.celesca.bookserver.Controller;

import com.example.celesca.bookserver.Model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final List<Book> books = List.of(
        new Book("The Great Gatsby", "F. Scott Fitzgerald", "https://images-na.ssl-images-amazon.com/images/I/51Z6Zzq9OEL._SX331_BO1,204,203,200_.jpg")
    );

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        for (Book book : books) {
            return books;
        }
    }
}
