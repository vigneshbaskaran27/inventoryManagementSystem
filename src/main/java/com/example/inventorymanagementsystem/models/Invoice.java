package com.example.inventorymanagementsystem.models;

import com.example.inventorymanagementsystem.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Invoice extends BaseModel {

    @OneToOne
    private PurchaseOrder purchaseOrder;
    private int amountPayable;
    @OneToOne
    private Vendor vendor;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
