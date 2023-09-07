package com.example.BookStore.controller;

import com.example.BookStore.entity.User;
import com.example.BookStore.exception.UserException;
import com.example.BookStore.service.JwtGeneratorInterface;
import com.example.BookStore.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class JwUserController {

    private LoginUserService userService;
//
//    @Autowired
//    UserRepository userRepository;

    @Autowired
    JwtGeneratorInterface jwtGeneratorInterface;
    @Autowired
    public JwUserController(LoginUserService userService){
        this.userService=userService;
        //  this.jwtGenerator=jwtGenerator;
    }

//    @Autowired
//    LoginUserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody User user){
        try{
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            if(user.getEmail() == null || user.getPassword() == null) {
                throw new UserException("UserName or Password is Empty");
            }
            User userData = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
            if(userData == null){
                throw new UserException("UserName or Password is Invalid");
            }
            return new ResponseEntity<>(jwtGeneratorInterface.generateToken(user), HttpStatus.OK);
        } catch (UserException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
