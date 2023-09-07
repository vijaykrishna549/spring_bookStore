package com.example.BookStore.controller;

import com.example.BookStore.dao.CartDao;
import com.example.BookStore.dto.ResponseDTO;
import com.example.BookStore.entity.CartEntity;
import com.example.BookStore.repository.CartRepository;
import com.example.BookStore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartData")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    CartRepository cartRepository;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createCart(@RequestBody CartEntity cartEntity) {
        CartEntity cartEntity1 = cartService.createCart(cartEntity);
        ResponseDTO responseDTO = new ResponseDTO("Created new Cart", cartEntity1);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAllCart")
    public ResponseEntity<List<CartEntity>> getAllCart() {
        try {
            List<CartEntity> cartEntities = new ArrayList<>();
            cartEntities = cartService.getAllCart();
            return new ResponseEntity<>(cartEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getCartById/{id}")
    public ResponseEntity<CartEntity> getCartById(@PathVariable int id) {
        Optional<CartEntity> cartEntity = cartRepository.findById(id);
        if (cartEntity.isPresent()) {
            return new ResponseEntity<>(cartEntity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/deleteCartById/{id}")
    public ResponseEntity<ResponseDTO> deleteCartById(@PathVariable int id){
        cartService.deleteCartById(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted cart with id ", id);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateCart(@PathVariable int id, @RequestBody CartDao cartDao){
        CartEntity cartEntity = cartService.updateCart(id,cartDao);
        ResponseDTO responseDTO = new ResponseDTO("Updated cart successfully", cartEntity);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}

