package com.example.BookStore.controller;

import com.example.BookStore.dao.UserDao;
import com.example.BookStore.dto.ResponseDTO;
import com.example.BookStore.entity.UserEntity;
import com.example.BookStore.repository.UserRepository;
import com.example.BookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Controller
@RestController
@RequestMapping("/userData")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

//    @Autowired
//    JwtGeneratorInterface jwtGeneratorInterface;

    //      if (StringUtils.isBlank(book.getTitle())) {
//            throw new ValidationError("Title cannot be empty");
//        }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody UserEntity userEntity) {
        UserEntity userEntity1 = userService.createUser(userEntity);
        ResponseDTO responseDTO = new ResponseDTO("Added User successfully", userEntity1);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllUserData")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> userEntityList = new ArrayList<>();
        ResponseDTO responseDTO = new ResponseDTO("User data fetched successfully", userEntityList);
        userEntityList = userService.getAllUsers();
        return new ResponseEntity<>(userEntityList, HttpStatus.OK);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            return new ResponseEntity<>(userEntity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<ResponseDTO> deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted user data" ,"Deleted Id : " + id);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable int id, @RequestBody UserDao userDao){
        UserEntity user = userService.updateUser(id,userDao);
        ResponseDTO responseDTO = new ResponseDTO("Updated user data",user);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


//    @PostMapping("/register")
//    public ResponseEntity<?> postUser(@RequestBody UserEntity user){
//        try{
//            userService.saveUser(user);
//            return new ResponseEntity<>(user, HttpStatus.CREATED);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//    }
//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody UserEntity user) {
//        try {
//            if(user.getEmail() == null || user.getPassword() == null) {
//                throw new UserException("UserName or Password is Empty");
//            }
//            UserEntity userData = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
//            if(userData == null){
//                throw new UserException("UserName or Password is Invalid");
//            }
//            return new ResponseEntity<>(jwtGeneratorInterface.generateToken(user), HttpStatus.OK);
//        } catch (UserException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//    }
}
