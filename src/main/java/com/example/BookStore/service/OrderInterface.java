package com.example.BookStore.service;

import com.example.BookStore.dao.OrderDao;
import com.example.BookStore.entity.OrderEntity;

import java.util.List;

public interface OrderInterface {

    OrderEntity createOrder(OrderEntity orderEntity);

    List<OrderEntity> getAllOrders();

    OrderEntity getOrderById(int id);

    void deleteOrderById(int id);

    OrderEntity updateCart (int id, OrderDao orderDao);
}
