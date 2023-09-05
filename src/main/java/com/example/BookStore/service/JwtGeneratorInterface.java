package com.example.BookStore.service;

import com.example.BookStore.entity.User;

import java.util.Map;


public interface JwtGeneratorInterface {
    Map<String, String> generateToken(User user);
}
