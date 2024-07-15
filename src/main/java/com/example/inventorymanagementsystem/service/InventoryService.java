package com.example.inventorymanagementsystem.service;

import com.example.inventorymanagementsystem.models.Product;
import com.example.inventorymanagementsystem.models.ProductType;
import com.example.inventorymanagementsystem.repository.InventoryRepository;
import com.example.inventorymanagementsystem.strategy.QRRead;
import com.example.inventorymanagementsystem.strategy.QRgenerator;
import com.example.inventorymanagementsystem.strategy.QrGeneratorStrategy;
import com.example.inventorymanagementsystem.strategy.QrReadStrategy;
import com.google.zxing.*;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//###zXING IMPORTS##

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    public QrGeneratorStrategy qrGeneratorStrategy ;
    @Autowired
    public QrReadStrategy qrReadStrategy;

    public Product createItem(long Id , String name , String Description , int amount , int Quantity, String Type , String TypeDescription) {

        Optional<Product> optionalItem= inventoryRepository.findById(Id);
        if(optionalItem.isPresent()) {
            return null;
        }
        Product product = new Product();
        product.setName(name);
        product.setDescription(Description);
        product.setPrice(amount);
        product.setQuantity(Quantity);
        ProductType productType = new ProductType();
        productType.setType(Type);
        productType.setDescription(TypeDescription);
        product.setProductType(productType);

        inventoryRepository.save(product);

        return product;
    }


    @Transactional
    public Product processBarcode(String barcode, int Quantity , String movement) {
        Optional<Product> optionalProduct = inventoryRepository.findById(Long.parseLong(barcode));
        if(!optionalProduct.isPresent()) {
            throw new IllegalArgumentException("Invalid barcode");
        }
        Product product = optionalProduct.get();

        if(!movement.equals("IN") || !movement.equals("OUT")){
            throw new IllegalArgumentException("Invalid movement type");
        }

        if(movement.equals("OUT") && product.getQuantity() < Quantity )
        {
            throw new IllegalArgumentException("Required quantity greater than available quantity" + Quantity);
        }

        if(movement.equals("OUT"))
        {
            int availableQty = product.getQuantity();
            int requiredQty = Quantity;
            product.setQuantity(availableQty-requiredQty);
            Product updatedProduct=inventoryRepository.save(product);
            return updatedProduct;

        }else
        {
            int availableQty = product.getQuantity();
            int requiredQty = Quantity;
            product.setQuantity(availableQty+requiredQty);
            Product updatedProduct=inventoryRepository.save(product);
            return updatedProduct;
        }
    }


    public  void createQR(String data, String path,
                                String charset, Map<EncodeHintType, ErrorCorrectionLevel> hashMap,
                                int height, int width) throws IOException, WriterException {
        QRgenerator qRgenerator = qrGeneratorStrategy.getQRgenerator();
        qRgenerator.generateQR( data,  path , charset,  hashMap, height,  width);

    }

    public Product getProductByID(long id) {
        Optional<Product> optionalProduct= inventoryRepository.findById(id);
        if(!optionalProduct.isPresent()) {
            return null;
        }

        return optionalProduct.get();

    }

    // Function to read the QR file
    public  String readQR(String path, String charset,
                          Map<EncodeHintType, ErrorCorrectionLevel> hashMap)
            throws FileNotFoundException, IOException,
            NotFoundException
    {
       QRRead qrRead = qrReadStrategy.getZxingQRReader();
      return  qrRead.readQR(path, charset, hashMap);
    }

}
