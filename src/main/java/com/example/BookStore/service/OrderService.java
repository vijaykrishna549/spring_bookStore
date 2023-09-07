package com.example.BookStore.service;

import com.example.BookStore.dao.OrderDao;
import com.example.BookStore.entity.OrderEntity;
import com.example.BookStore.exception.UserException;
import com.example.BookStore.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderService implements OrderInterface{

    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderEntity createOrder(OrderEntity orderEntity) {
       OrderEntity orderEntity1 = new OrderEntity(orderEntity);
       return orderRepository.save(orderEntity1);
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return (List<OrderEntity>) orderRepository.findAll();
    }

    @Override
    public OrderEntity getOrderById(int id) {
     return orderRepository.findById(id).orElseThrow(() -> new UserException("Order with !!" + id + "does not exists"));

    }

    @Override
    public void deleteOrderById(int id) {
        OrderEntity orderEntity = this.getOrderById(id);
        orderRepository.delete(orderEntity);
    }

    @Override
    public OrderEntity updateCart(int id, OrderDao orderDao) {
     OrderEntity orderEntity = this.getOrderById(id);
     orderEntity.updateOrder(orderDao);
     return orderRepository.save(orderEntity);
    }
}
