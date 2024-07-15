package com.example.inventorymanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ProductOrder extends BaseModel{
    @OneToOne
    private Product product;
    private long purchaseQuantity;
    private long saleQuantity;
}
