package com.example.BookStore.controller;

import com.example.BookStore.dao.OrderDao;
import com.example.BookStore.dto.ResponseDTO;
import com.example.BookStore.entity.OrderEntity;
import com.example.BookStore.repository.OrderRepository;
import com.example.BookStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderData")

public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addCart(@RequestBody OrderEntity orderEntity) {
        OrderEntity orderEntity1 = orderService.createOrder(orderEntity);
        ResponseDTO responseDTO = new ResponseDTO("Created new order successfully", orderEntity1);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderEntity>> getAllOrders(){
        try{
            List<OrderEntity> orderEntities = new ArrayList<>();
            orderEntities = orderService.getAllOrders();
            return new ResponseEntity<>(orderEntities, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable int id){
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);
        if (orderEntity.isPresent()){
            return new ResponseEntity<>(orderEntity.get(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteOrderById/{id}")
    public ResponseEntity<ResponseDTO> deleteOrderById(@PathVariable int id){
        orderService.deleteOrderById(id);
        ResponseDTO responseDTO = new ResponseDTO("Delted cart by id : ", id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateCart(@PathVariable int id, @RequestBody OrderDao orderDao){
        OrderEntity orderEntity = orderService.updateCart(id,orderDao);
        ResponseDTO responseDTO = new ResponseDTO("Updated Order : ", orderEntity);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}
