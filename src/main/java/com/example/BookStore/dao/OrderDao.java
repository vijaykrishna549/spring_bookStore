package com.example.BookStore.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderDao {
    public LocalDate orderDate;
    public int quantity;
    public String address;
    public int userId;
    public int bookId;
    public boolean cancel;
}
