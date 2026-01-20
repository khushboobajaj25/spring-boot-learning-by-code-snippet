package com.codesnippet.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesnippet.demo.entity.Book;
import com.codesnippet.demo.service.BookService;

@RestController
@RequestMapping("/book/v1")
public class BookController {
    
    
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService  = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Book book){
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @GetMapping("getBook/{title}")
    public ResponseEntity getBookByName(@PathVariable String title){
        Book book = bookService.getBookByName(title);
        return ResponseEntity.ok(book);
    }

     @PutMapping("updateBook")
    public ResponseEntity updateBook(@RequestBody Book book){
       Book updatedBook = bookService.updateBook(book);
       return ResponseEntity.ok(updatedBook);

    }
}
