package com.dogukan.service;


import com.dogukan.domain.Book;
import com.dogukan.dto.BookDTO;
import com.dogukan.exceptions.BookNotFoundException;
import com.dogukan.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
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

    public void updateBookById(Long id, BookDTO bookDTO) {
        Book existingBook = getBookById(id);

        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setPublicationDate(bookDTO.getPublicationDate());
        bookRepository.save(existingBook);
    }

    public Page<Book> getAllBookWithPage(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public List<Book> getBookJpqlByAuthor(String author) {

        List<Book> bookList = bookRepository.findByAuthorWithJPQL(author);
        if (bookList.isEmpty()) {
            throw new BookNotFoundException("Yazara ait kitap bulunamadi!");
        }

        return bookList;
    }
}
