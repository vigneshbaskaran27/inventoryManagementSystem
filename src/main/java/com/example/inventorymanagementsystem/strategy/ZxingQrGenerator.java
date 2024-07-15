package com.example.inventorymanagementsystem.strategy;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


//###zXING IMPORTS##


import java.io.File;
import java.io.IOException;
import java.util.Map;



public class ZxingQrGenerator implements QRgenerator{
    @Override
    public void generateQR(String data, String path,
                           String charset, Map<EncodeHintType, ErrorCorrectionLevel> hashMap,
                           int height, int width)
            throws WriterException, IOException {

        //bITMATRIX USED TO ENCODE ALL THE PASSED DATA
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, width, height);

        //MATRIX TO IMAGE WRITER USED TO SCAN THE QR TO GET DETAILS
        MatrixToImageWriter.writeToFile(
                matrix,
                path.substring(path.lastIndexOf('.') + 1),
                new File(path));
    }
}
