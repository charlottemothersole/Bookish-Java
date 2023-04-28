package com.bookishjava.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookishjava.models.database.Book;
import com.bookishjava.repositories.BookRepository;

@RestController
public class BookController {
    
    private final BookRepository repository;

    BookController(BookRepository repository){
        this.repository = repository;
    }

    @GetMapping("/books")
    List<Book> getBooks(){
        return repository.findAll();
    }
}
