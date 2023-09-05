package com.example.BookStore.service;

import com.example.BookStore.entity.BookEntity;
import com.example.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService implements BookInterface{

    @Autowired
    BookRepository bookRepository;
    @Override
    public BookEntity addBook(BookEntity bookEntity) {
        BookEntity book = new BookEntity(bookEntity);
        return bookRepository.save(book);
    }
}
