package com.example.BookStore.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class UserDao {
    public String firstName;
    public String lastName;
    public LocalDate dob;
    public LocalDate registeredDate;
    public LocalDate updatedDate;
    public String password;
    public String email;
    public Boolean verify;
    public String otp;
}
