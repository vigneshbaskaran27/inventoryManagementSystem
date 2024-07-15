package com.example.inventorymanagementsystem.controllers;

import com.example.inventorymanagementsystem.Dtos.BarcodeRequestDto;
import com.example.inventorymanagementsystem.Dtos.ProductRequestDto;
import com.example.inventorymanagementsystem.models.Product;
import com.example.inventorymanagementsystem.service.InventoryService;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Java code to generate QR code

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.EncodeHintType;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @PostMapping("/create")
    public ResponseEntity<Product> createItem(@RequestBody ProductRequestDto productRequestDto)
    {
        Product product;
        try{
            product = inventoryService.createItem(productRequestDto.getId() , productRequestDto.getName() , productRequestDto.getDescription(),
                     productRequestDto.getPrice() , productRequestDto.getQuantity(), productRequestDto.getProductTypeDto().getType(),
                    productRequestDto.getProductTypeDto().getDescription());

            if(product == null)
                throw new RuntimeException("Product already exists");

            return new ResponseEntity<>(product, HttpStatus.OK);

        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/barcodeProcess")
    public String processBarcode(@RequestBody BarcodeRequestDto barcodeRequestDto)
    {

        return null;
    }

    @GetMapping("/createQR")
    public void CreateQR() throws IOException, WriterException {
        // The data that the QR code will contain
        Product product = inventoryService.getProductByID(1);

        String data = ""+product.getId();
        data+=product.getName();
        data+=product.getDescription();
        data+=product.getPrice();
        data+=product.getProductType();


        // The path where the image will get saved
        String path = "Product.jpg";

        // Encoding charset
        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                = new HashMap<EncodeHintType,
                ErrorCorrectionLevel>();

        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                ErrorCorrectionLevel.L);

        // Create the QR code and save
        // in the specified folder
        // as a jpg file
        inventoryService.createQR(data, path, charset, hashMap, 200, 200);
        String filename = "Product.jpg";  // Replace with your desired filename
        File imageFile = new File(path + filename);
        // Write your image data to the file (replace with your image processing logic)

        System.out.println("QR Code Generated!!! ");
    }

    @PostMapping("/scanQR")
    public void scanQrCode() throws IOException, WriterException, NotFoundException {
        {

            // Path where the QR code is saved
            String filePath = "C:\\Users\\vicky\\IdeaProjects\\InventoryManagementSystem\\Product.jpg";

            // Encoding charset
            String charset = "UTF-8";

            Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                    = new HashMap<EncodeHintType,
                    ErrorCorrectionLevel>();

            hashMap.put(EncodeHintType.ERROR_CORRECTION,
                    ErrorCorrectionLevel.L);

            System.out.println(
                    "QRCode output: "
                            + inventoryService.readQR(filePath, charset, hashMap));
        }

    }

    @PutMapping ("/update")
    public void updateItem(){}

    @DeleteMapping("/delete")
    public void deleteItem(){}

    @GetMapping("/item/{id}")
    public void getItem(){}

    @GetMapping("/items")
    public void getAllItems(){}

}
