package com.example.BookStore.service;

import com.example.BookStore.dao.BookDao;
import com.example.BookStore.entity.BookEntity;
import com.example.BookStore.exception.UserException;
import com.example.BookStore.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService implements BookInterface{

    @Autowired
    BookRepository bookRepository;
    @Override
    public BookEntity addBook(BookEntity bookEntity) {
        BookEntity book = new BookEntity(bookEntity);
        return bookRepository.save(book);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return (List<BookEntity>) bookRepository.findAll();
    }

    @Override
    public BookEntity getBookById(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new UserException("Person with !!" + id + "does not exists"));
    }

    @Override
    public void deleteBookById(int id) {
        BookEntity bookEntity = this.getBookById(id);
        bookRepository.delete(bookEntity);
    }

    @Override
    public BookEntity updateBook(int id, BookDao bookDao) {
        BookEntity book = this.getBookById(id);
        book.updateBook(bookDao);
        return bookRepository.save(book);
    }
}
