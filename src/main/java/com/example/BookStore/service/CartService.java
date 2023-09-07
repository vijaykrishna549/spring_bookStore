package com.example.BookStore.service;

import com.example.BookStore.dao.CartDao;
import com.example.BookStore.entity.CartEntity;
import com.example.BookStore.exception.UserException;
import com.example.BookStore.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartService implements CartInterface {

    @Autowired
    CartRepository cartRepository;

    @Override
    public CartEntity createCart(CartEntity cartEntity) {
        CartEntity cartEntity1 = new CartEntity(cartEntity);
        return cartRepository.save(cartEntity1);
    }

    @Override
    public List<CartEntity> getAllCart() {
        return (List<CartEntity>) cartRepository.findAll();
    }

    @Override
    public CartEntity getCartById(int id) {
      return cartRepository.findById(id).orElseThrow(() -> new UserException("Cart with !!" + id + "does not exists"));
    }

    @Override
    public void deleteCartById(int id) {
        CartEntity cartEntity = this.getCartById(id);
        cartRepository.delete(cartEntity);
    }

    @Override
    public CartEntity updateCart(int id, CartDao cartDao) {
        CartEntity cartEntity1  = this.getCartById(id);
        cartEntity1.updateCart(cartDao);
        return cartRepository.save(cartEntity1);
    }
}
