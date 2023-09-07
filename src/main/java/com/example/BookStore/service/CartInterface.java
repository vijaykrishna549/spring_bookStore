package com.example.BookStore.service;

import com.example.BookStore.dao.CartDao;
import com.example.BookStore.entity.CartEntity;

import java.util.List;

public interface CartInterface {
    public CartEntity createCart( CartEntity cartEntity);

    List<CartEntity> getAllCart();

    CartEntity getCartById(int id);

    void deleteCartById(int id);

    CartEntity updateCart(int id, CartDao cartDao);
}
