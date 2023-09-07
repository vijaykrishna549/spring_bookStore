package com.example.BookStore.controller;

import com.example.BookStore.dao.BookDao;
import com.example.BookStore.dto.ResponseDTO;
import com.example.BookStore.entity.BookEntity;
import com.example.BookStore.repository.BookRepository;
import com.example.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("bookData")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addBook(@RequestBody BookEntity bookEntity) {
        BookEntity bookEntity1 = bookService.addBook(bookEntity);
        ResponseDTO responseDTO = new ResponseDTO("Added Book Succesfully", bookEntity1);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookEntity>> getAllBooks(){
        try {
            List<BookEntity> bookEntities = new ArrayList<>();
            bookEntities = bookService.getAllBooks();
            return new ResponseEntity<>(bookEntities,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getBookById/{id}")
    public ResponseEntity<BookEntity> getBookById (@PathVariable int id ){
        Optional<BookEntity> book = bookRepository.findById(id);
        if(book.isPresent()){
            return new ResponseEntity<>(book.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity <ResponseDTO> deleteBookById (@PathVariable int id){
        bookService.deleteBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Book by id",id);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO>updateBook(@PathVariable int id, @RequestBody BookDao bookDao){
        BookEntity book = bookService.updateBook(id,bookDao);
        ResponseDTO responseDTO = new ResponseDTO("Updated Book by id",id);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
