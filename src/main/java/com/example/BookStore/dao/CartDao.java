package com.example.BookStore.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartDao {
    public int userId;
    public int bookId;
    public int quantity;
    public int totalPrice;

}
