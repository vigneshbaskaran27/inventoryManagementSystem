package com.example.inventorymanagementsystem.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ProductType extends BaseModel{
    private String type;
    private String description;
}
