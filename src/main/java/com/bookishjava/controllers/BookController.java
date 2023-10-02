package com.bookishjava.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.bookishjava.models.database.Book;
import com.bookishjava.repositories.BookRepository;

@RestController
public class BookController {
    
    private final BookRepository repository;

    BookController(BookRepository repository){
        this.repository = repository;
    }

    @GetMapping("/books")
    @CrossOrigin(origins = "http://localhost:5173")
    List<Book> getBooks(){
        return repository.findAll();
    }

    //why doesnt this path work if I use get-books instead of books?
    @GetMapping("/books/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    Optional<Book> getBookById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/books")
    void addBook(@RequestBody Book book) {
        repository.save(book);
    }
}

//First, create a new controller called BookController. Mark this controller with the @RestController attribute.
// This allows the controller to be automatically detected by the web app and indicates that every method of the controller should
// inherit the @ResponseBody annotation (this means the method will return JSON rather than trying to render an HTML template).
// The controller will need a BookRepository instance variable so that it can query the database.
//
//        Within the BookController, define a new method called getBooks that returns a list of Books. This method should also be marked
//        with the @GetMapping("<route>") annotation ("books" is probably a sensible value for <route>). This method should return a list
//        of all the Books in the BookRepository.
//
//        To test your endpoint is working, simply run the app with ./gradlew bootRun and use your browser or a tool like Postman
//        to test your API endpoint and check that it’s all working as intended. Provided you followed the instructions above the endpoint
//        url should be http://localhost:<port>/books. It should return a JSON-formatted list of all the books in your database.
//
//        If you’re struggling, you may find the Spring RESTful Web service documentation, and some parts of the Spring Web MVC docs to be helpful.
//
//        Once you’re satisfied that that’s working, have a go at implementing a few more of the features in your API,
//        starting with a POST endpoint to add a new book to the library.