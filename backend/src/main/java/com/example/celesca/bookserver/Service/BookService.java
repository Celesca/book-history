package com.example.celesca.bookserver.Service;

import com.example.celesca.bookserver.Model.Book;
import com.example.celesca.bookserver.Repository.BookRepository;
import com.example.celesca.bookserver.Request.BookRequestDto;
import com.example.celesca.bookserver.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> GetBooks() {
        return bookRepository.findAll();
    }

    public Book AddBook(BookRequestDto bookRequestBody) {
        if (bookRequestBody.getTitle().trim().isEmpty()) {
            throw new BadRequestException("Title cannot be empty");
        }

        Book book = new Book(bookRequestBody.getTitle(), bookRequestBody.getAuthor(), bookRequestBody.getImage());

        bookRepository.save(book);
        return book;
    }

    public Book UpdateBook(Long id, BookRequestDto bookRequestBody) {
        if (!bookRepository.existsById(id)) {
            throw new BadRequestException("Book not found");
        }

        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookRequestBody.getTitle());
            book.setAuthor(bookRequestBody.getAuthor());
            book.setImage(bookRequestBody.getImage());

            // Save the updated book to the repository
            return bookRepository.save(book);
        } else {
            throw new BadRequestException("Book not found");
        }
    }

    public String DeleteBook(Long id) {

        if (!bookRepository.existsById(id)) {
            throw new BadRequestException("Book not found");
        }
        bookRepository.deleteById(id);
        return "Book deleted successfully";
    }
}
