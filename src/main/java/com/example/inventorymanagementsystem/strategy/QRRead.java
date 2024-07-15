package com.example.inventorymanagementsystem.strategy;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface QRRead {
    String readQR(String path, String charset,
                  Map<EncodeHintType, ErrorCorrectionLevel> hashMap) throws FileNotFoundException, IOException, NotFoundException;
}
