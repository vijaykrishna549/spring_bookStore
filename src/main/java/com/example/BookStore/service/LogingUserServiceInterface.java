package com.example.BookStore.service;

import com.example.BookStore.entity.User;
import com.example.BookStore.exception.UserException;
import org.springframework.stereotype.Service;

@Service
public interface LogingUserServiceInterface {


    public void saveUser(User user);

    public User getUserByEmailAndPassword(String email, String password) throws UserException;
}

