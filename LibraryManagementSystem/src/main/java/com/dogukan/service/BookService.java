package com.dogukan.service;


import com.dogukan.domain.Book;
import com.dogukan.exceptions.BookNotFoundException;
import com.dogukan.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;

    //1
    public void saveBook(Book book) {

        bookRepository.save(book);
    }

    //2
    public List<Book> getAll() {

        return bookRepository.findAll();
    }

    //3
    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Kitap bulunamadi, ID : " + id));

        return book;
    }

    public void deleteBookById(Long id) {
        // Book book = getBookById(id);
        // bookRepository.delete(book);
        bookRepository.deleteById(id);//yukaridakiyle ayni islemler
    }

    public List<Book> getBookByTitle(String title) {

        List<Book> book;
        book = bookRepository.findByTitleContaining(title);
        return book;
    }
}
