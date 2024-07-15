package com.example.inventorymanagementsystem.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Product extends BaseModel {
    private String name;
    private String description;
    private int price;
    private int quantity;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProductType productType;


}
