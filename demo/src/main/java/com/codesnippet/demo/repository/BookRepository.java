package com.codesnippet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codesnippet.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
    
    public Book findByTitle(String title);
}
