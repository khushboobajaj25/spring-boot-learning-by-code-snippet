package com.codesnippet.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesnippet.demo.entity.Book;
import com.codesnippet.demo.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book getBookByName(String name){
        return bookRepository.findByTitle(name);
    }

    public Book updateBook(Book book){
        return bookRepository.save(book);
    }
}
