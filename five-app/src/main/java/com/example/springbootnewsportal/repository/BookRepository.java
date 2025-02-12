package com.example.springbootnewsportal.repository;

import com.example.bookmanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitleAndAuthor(String title, String author);
    List<Book> findByCategoryName(String categoryName);
}