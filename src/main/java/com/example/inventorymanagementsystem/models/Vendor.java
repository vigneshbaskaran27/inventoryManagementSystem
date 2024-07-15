package com.example.inventorymanagementsystem.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Vendor extends BaseModel{
    private String name;
    private String email;
    private String phone;
    private String address;
}
