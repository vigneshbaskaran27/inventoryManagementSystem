package com.example.inventorymanagementsystem.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QrGeneratorStrategy {

    public ZxingQrGenerator zxingQrGenerator;

    public ZxingQrGenerator getQRgenerator() {
        return new ZxingQrGenerator();
        }
    }

