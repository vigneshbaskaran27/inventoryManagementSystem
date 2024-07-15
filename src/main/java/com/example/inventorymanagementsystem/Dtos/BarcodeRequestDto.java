package com.example.inventorymanagementsystem.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class BarcodeRequestDto {
    private String barcode;
    private int quantity;
    private String movement;
}
