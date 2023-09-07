package com.example.BookStore.service;

import com.example.BookStore.entity.User;

import java.util.Map;

@FunctionalInterface
public interface JwtGeneratorInterface {
    Map<String, String> generateToken(User user);
}
