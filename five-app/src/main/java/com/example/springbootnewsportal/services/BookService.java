package com.example.springbootnewsportal.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Cacheable(value = "bookCache", key = "#title + #author")
    public Book findBookByTitleAndAuthor(String title, String author) {
        return bookRepository.findByTitleAndAuthor(title, author);
    }

    @Cacheable(value = "booksByCategoryCache", key = "#categoryName")
    public List<Book> findBooksByCategoryName(String categoryName) {
        return bookRepository.findByCategoryName(categoryName);
    }

    @CacheEvict(value = {"bookCache", "booksByCategoryCache"}, allEntries = true, beforeInvocation = true)
    public Book createBook(Book book, String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        if (category == null) {
            category = new Category();
            category.setName(categoryName);
            categoryRepository.save(category);
        }
        book.setCategory(category);
        return bookRepository.save(book);
    }

    @CacheEvict(value = {"bookCache", "booksByCategoryCache"}, allEntries = true, beforeInvocation = true)
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setCategory(bookDetails.getCategory());
        return bookRepository.save(book);
    }

    @CacheEvict(value = {"bookCache", "booksByCategoryCache"}, allEntries = true, beforeInvocation = true)
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}