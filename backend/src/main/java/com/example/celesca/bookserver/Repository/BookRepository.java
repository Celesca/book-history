package com.example.celesca.bookserver.Repository;

import com.example.celesca.bookserver.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByTitle(String title);
    Book findByTitle(String title);
}
