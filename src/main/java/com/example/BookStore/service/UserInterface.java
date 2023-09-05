package com.example.BookStore.service;

import com.example.BookStore.dao.UserDao;
import com.example.BookStore.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface UserInterface {

    public UserEntity  createUser(UserEntity userEntity);

    List<UserEntity> getAllUsers();

    UserEntity getUserById(int id);

    void deleteUserById(int id);

    UserEntity updateUser(int id, UserDao userDao);
//    public UserEntity findByUserNameAndPassword(String userName, String password);

//    public void saveUser(UserEntity user);
//    public UserEntity getUserByEmailAndPassword(String email, String password) throws UserException;

}
