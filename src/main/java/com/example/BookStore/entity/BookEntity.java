package com.example.BookStore.entity;

import com.example.BookStore.dao.BookDao;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bookData")
@Data
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookName;
    private String bookAuthor;
    private String bookDescription;
    private String logo;
    private int bookPrice;
    private int bookQuantity;

    public BookEntity() {

    }
    public BookEntity(BookEntity bookEntity) {
        this.id = bookEntity.id;
        this.bookName = bookEntity.bookName;
        this.bookAuthor = bookEntity.bookAuthor;
        this.bookDescription = bookEntity.bookDescription;
        this.logo = bookEntity.logo;
        this.bookPrice = bookEntity.bookPrice;
        this.bookQuantity = bookEntity.bookQuantity;
    }

    public void updateBook(BookDao bookDao){
        this.bookName = bookDao.bookName;
        this.bookAuthor = bookDao.bookAuthor;
        this.bookDescription = bookDao.bookDescription;
        this.logo = bookDao.logo;
        this.bookPrice = bookDao.bookPrice;
        this.bookQuantity = bookDao.bookQuantity;
    }
}
