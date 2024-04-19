package com.example.celesca.bookserver.Service;

import com.example.celesca.bookserver.Model.Book;
import com.example.celesca.bookserver.Repository.BookRepository;
import com.example.celesca.bookserver.exception.BadRequestException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> GetBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book AddBook(Book bookRequestBody) {
        if (bookRequestBody.getTitle().trim().isEmpty()) {
            throw new BadRequestException("Title cannot be empty");
        }
        bookRepository.save(bookRequestBody);
        return bookRequestBody;
    }
}
