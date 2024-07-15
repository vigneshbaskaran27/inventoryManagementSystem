package com.example.inventorymanagementsystem.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ProductRequestDto {
    private int Id;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private ProductTypeDto productTypeDto;
}
