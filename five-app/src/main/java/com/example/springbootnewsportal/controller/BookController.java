package com.example.springbootnewsportal.controller;

import com.example.springbootnewsportal.entity.Book;
import com.example.springbootnewsportal.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/find")
    public Book findBookByTitleAndAuthor(@RequestParam String title, @RequestParam String author) {
        return bookService.findBookByTitleAndAuthor(title, author);
    }

    @GetMapping("/category")
    public List<Book> findBooksByCategoryName(@RequestParam String categoryName) {
        return bookService.findBooksByCategoryName(categoryName);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book, @RequestParam String categoryName) {
        return bookService.createBook(book, categoryName);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}