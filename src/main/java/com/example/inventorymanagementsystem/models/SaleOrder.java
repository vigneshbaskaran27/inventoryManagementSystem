package com.example.inventorymanagementsystem.models;

import com.example.inventorymanagementsystem.enums.SaleOrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class SaleOrder extends BaseModel{
    @OneToMany
    private List<ProductOrder> productOrders;

    private int customerId;

    @Enumerated(EnumType.ORDINAL)
    private SaleOrderStatus saleOrderStatus;

}
