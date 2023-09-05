package com.example.BookStore.service.jwtGenerator;

import com.example.BookStore.entity.UserEntity;

import java.util.Map;

public interface JwtGeneratorInterface {
    Map<String, String> generateToken(UserEntity userEntity);
}
