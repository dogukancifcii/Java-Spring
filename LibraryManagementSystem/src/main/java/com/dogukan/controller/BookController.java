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

    //3-Get a book by id,return : Book
    //http://localhost:8080/books/2 + GET
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {

        Book foundBook = bookService.getBookById(id);

        return new ResponseEntity<>(foundBook, HttpStatus.OK);
    }

    //4- delete a book by ID,return: String
    //http://localhost:8080/books/1 + DELETE JSON(BODY)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Kitap basariyla silindi", HttpStatus.OK);
    }

    //5- Get a Book by ID with RequestParam , Return : Book
    //http://localhost:8080/books/q?id=2 + GET
    @GetMapping("/q")
    public ResponseEntity<Book> getBookByIdWithQuery(@RequestParam("id") Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    //6- Get a Book by Title with RequestParam , Return : Book
    @GetMapping("/search")
    public ResponseEntity<Book> getBookByTitleWithQuery(@RequestParam("title") String title) {
        Book book = bookService.getBookByTitle(title);
        return ResponseEntity.ok(book);
    }
}
