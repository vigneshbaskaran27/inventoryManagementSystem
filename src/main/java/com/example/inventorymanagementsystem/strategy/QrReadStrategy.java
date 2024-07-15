package com.example.inventorymanagementsystem.strategy;

import org.springframework.stereotype.Component;

@Component
public class QrReadStrategy {

    public ZxingQRReader zxingQRReader ;

    public static ZxingQRReader getZxingQRReader() {
        return new ZxingQRReader();
    }
}
