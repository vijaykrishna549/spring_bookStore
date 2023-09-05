package com.example.BookStore.repository;

import com.example.BookStore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
