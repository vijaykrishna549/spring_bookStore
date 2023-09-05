package com.example.BookStore.service;

import com.example.BookStore.entity.User;
import com.example.BookStore.exception.UserException;
import com.example.BookStore.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService implements LogingUserServiceInterface {
    private
    @Autowired
    LoginUserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws UserException {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new UserException("Invalid id and password");
        }
        return user;
    }
}

