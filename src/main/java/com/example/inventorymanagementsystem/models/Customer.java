package com.example.inventorymanagementsystem.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Customer extends BaseModel {
    private String name;
    private String email;
    private String phone;
}
