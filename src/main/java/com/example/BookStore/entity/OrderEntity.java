package com.example.BookStore.entity;

import com.example.BookStore.dao.OrderDao;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "oderData")
@Data

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate orderDate;
    private int quantity;
    private String address;
    private int userId;
    private int bookId;
    private boolean cancel;

    public OrderEntity(OrderEntity orderEntity) {
        this.id = orderEntity.id;
        this.orderDate = orderEntity.orderDate;
        this.quantity = orderEntity.quantity;
        this.address = orderEntity.address;
        this.userId = orderEntity.userId;
        this.bookId = orderEntity.bookId;
        this.cancel = orderEntity.cancel;
    }

    public OrderEntity(){

    }

    public void updateOrder(OrderDao orderDao) {
        this.userId = orderDao.userId;
        this.bookId = orderDao.bookId;
        this.quantity = orderDao.quantity;
        this.address = orderDao.address;
        this.cancel = orderDao.cancel;
        this.orderDate = orderDao.orderDate;
    }
}
