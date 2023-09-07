package com.example.BookStore.service;

import com.example.BookStore.dao.BookDao;
import com.example.BookStore.entity.BookEntity;

import java.util.List;

public interface BookInterface {
BookEntity addBook(BookEntity bookEntity);

List<BookEntity> getAllBooks();

BookEntity getBookById(int id);

void deleteBookById(int id);

BookEntity updateBook (int id, BookDao bookDao);


}
