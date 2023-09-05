package com.example.BookStore.entity;

import com.example.BookStore.dao.UserDao;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table(name = "userdata")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
//    @Value( "First name can't be empty/null")
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private LocalDate registeredDate;
    private LocalDate updatedDate;
    private String password;
    private String email;
    private Boolean verify;
    private String otp;

    public UserEntity() {

    }

    public UserEntity(UserEntity userEntity) {

        this.id = userEntity.id;
        this.firstName = userEntity.firstName;
        this.lastName = userEntity.lastName;
        this.dob = userEntity.dob;
        this.registeredDate = userEntity.registeredDate;
        this.updatedDate = userEntity.updatedDate;
        this.password = userEntity.password;
        this.email = userEntity.email;
        this.verify = userEntity.verify;
        this.otp = userEntity.otp;
    }

    public void updateUser(UserDao userDao){
        this.firstName = userDao.firstName;
        this.lastName = userDao.lastName;
        this.dob = userDao.dob;
        this.registeredDate = userDao.registeredDate;
        this.updatedDate = userDao.updatedDate;
        this.password = userDao.password;
        this.email = userDao.email;
        this.verify = userDao.verify;
        this.otp = userDao.otp;
    }
}
