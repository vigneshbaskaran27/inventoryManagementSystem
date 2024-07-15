package com.example.inventorymanagementsystem.models;

import com.example.inventorymanagementsystem.enums.PurchaseOrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class PurchaseOrder extends BaseModel{
    private long vendorId;
    @OneToMany
    private List<ProductOrder> productOrders;
    @Enumerated(EnumType.ORDINAL)
    private PurchaseOrderStatus purchaseOrderStatus;
    @OneToOne
    private Invoice invoice;
}
