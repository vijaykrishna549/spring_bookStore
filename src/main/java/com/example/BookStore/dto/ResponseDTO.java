package com.example.BookStore.dto;


import com.example.BookStore.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, UserEntity data) {
        this.message = message;
        this.data = data;
    }
}
