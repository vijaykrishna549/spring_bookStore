package com.example.BookStore.service;

import com.example.BookStore.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtGeneratorImpl implements JwtGeneratorInterface {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${app.jwttoken.message}")
    private String message;

//    @Override
//    public Map<String, String> generateToken(UserEntity userEntity) {
//        String jwtToken = "";
//        jwtToken = Jwts.builder().setSubject(userEntity.getEmail()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secret").compact();
//        Map<String, String> jwtTokenGen = new HashMap<>();
//        jwtTokenGen.put("token", jwtToken);
//        jwtTokenGen.put("message", message);
//        return jwtTokenGen;
//    }

    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken = "";
        jwtToken = Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secret").compact();
        Map<String, String> jwtTokenGen = new HashMap<>();
        jwtTokenGen.put("token", jwtToken);
        jwtTokenGen.put("message", message);
        System.out.println("jwtTocken : "+jwtToken);
        System.out.println("jwtTokenGen : "+ jwtTokenGen);
        return jwtTokenGen;
    }
}

