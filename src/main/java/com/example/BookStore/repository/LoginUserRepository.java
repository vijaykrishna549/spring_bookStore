package com.example.BookStore.repository;

import com.example.BookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends JpaRepository<User, String> {

    public User findByEmailAndPassword(String userName, String password);
}
