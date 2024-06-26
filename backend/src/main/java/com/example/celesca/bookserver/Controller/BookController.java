package com.example.celesca.bookserver.Controller;

import com.example.celesca.bookserver.Model.Book;
import com.example.celesca.bookserver.Request.BookRequestDto;
import com.example.celesca.bookserver.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookService.GetBooks();
    }

    @PostMapping("/api/books")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Book addBook(@Valid @RequestBody BookRequestDto bookRequestBody) {
        System.out.println(bookRequestBody);
        return bookService.AddBook(bookRequestBody);
    }

    @PutMapping("/api/books/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Book updateBook(@PathVariable Long id, @Valid @RequestBody BookRequestDto bookRequestBody) {
        return bookService.UpdateBook(id, bookRequestBody);
    }

    @DeleteMapping("/api/books/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public String deleteBook(@PathVariable Long id) {
        return bookService.DeleteBook(id);
    }
}
