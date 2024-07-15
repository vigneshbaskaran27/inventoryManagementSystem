package com.example.inventorymanagementsystem.strategy;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public interface QRgenerator {

    void generateQR(String data, String path,
                    String charset, Map<EncodeHintType, ErrorCorrectionLevel> hashMap,
                    int height, int width)
            throws WriterException, IOException;
}
