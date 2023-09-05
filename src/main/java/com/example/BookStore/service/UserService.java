package com.example.BookStore.service;

import com.example.BookStore.dao.UserDao;
import com.example.BookStore.entity.UserEntity;
import com.example.BookStore.exception.UserException;
import com.example.BookStore.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService implements UserInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        UserEntity userEntity1 = new UserEntity(userEntity);
//              if (StringUtils.isBlank(book.getTitle())) {
//            throw new ValidationError("Title cannot be empty");
//        }
        if (StringUtils.isBlank(userEntity.getFirstName())) {
            throw new UserException("First name cannot be empty");
        }
        return userRepository.save(userEntity1);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>)
                userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(int id) {
        UserEntity user = this.getUserById(id);
        userRepository.delete(user);
    }

    @Override
    public UserEntity updateUser(int id, UserDao userDao) {
        UserEntity user = this.getUserById(id);
        user.updateUser(userDao);
        return userRepository.save(user);
    }

//    @Override
//    public void saveUser(UserEntity user) {
//        userRepository.save(user);
//    }
//
//    @Override
//    public UserEntity getUserByEmailAndPassword(String email, String password) throws UserException {
//        UserEntity user = userRepository.findByEmailAndPassword(email, password);
//        if (user == null) {
//            throw new UserException("Invalid id and password");
//        }
//        return user;
//    }
}

