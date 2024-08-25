package com.dogukan.controller;


import com.dogukan.domain.Book;
import com.dogukan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController//@Controller ve @ResponseBody birlesimidi
// Amaç: RESTful web servisleri oluşturmak için kullanılır. Her bir HTTP isteğine verilen yanıt, varsayılan olarak JSON veya XML gibi bir veri formatında doğrudan istemciye gönderilir.
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //CREATE
    //1- save a book & return : Message
    //http://localhost:8080/books + POST + BODY(JSON)
    @PostMapping
    public ResponseEntity<String> saveBook(@Valid @RequestBody Book book) {

        bookService.saveBook(book);

        //RequestBody ile JSON formatinda gelen verileri Book Classina gonderiyoruz
        //ResponseEntity HTTP status kod bulundurur o yuzden kullaniyoruz.


        return new ResponseEntity<>("Kitap basariyla kaydedildi.", HttpStatus.CREATED); //201 202
    }

    //READ
    //2- Get All Books,return : List<Book>
    //http://localhost:8080/books + GET
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAll();

        //return new ResponseEntity<>(bookList, HttpStatus.OK);
        return ResponseEntity.ok(bookList); //yukaridaki ile ayni

    }

    //3-Get a book by id : Book
    //http://localhost:8080/books/2 + GET
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {

        Book foundBook = bookService.getBookById(id);

        return new ResponseEntity<>(foundBook, HttpStatus.OK);
    }
}
