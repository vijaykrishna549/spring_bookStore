package com.example.BookStore.entity;

import com.example.BookStore.dao.CartDao;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cartData")
@Data
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
    private int userId;
    private int bookId;
    private int quantity;
    private int totalPrice;

    public CartEntity(){

    }

    public CartEntity(CartEntity cartEntity) {
        this.cartId = cartEntity.cartId;
        this.userId = cartEntity.userId;
        this.bookId = cartEntity.bookId;
        this.quantity = cartEntity.quantity;
        this.totalPrice = cartEntity.totalPrice;
    }

    public void updateCart(CartDao cartDao){
        this.userId = cartDao.userId;
        this.bookId = cartDao.bookId;
        this.quantity = cartDao.quantity;
        this.totalPrice = cartDao.totalPrice;
    }
}
