package com.productk12Api.controller;

import com.productk12Api.model.Category;
import com.productk12Api.model.MyResponse;
import com.productk12Api.model.Product;
import com.productk12Api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {
      return productService.save(product);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
       return productService.getListProduct();
    }
    @GetMapping("/getOne")
    public ResponseEntity<?> getOne() {
        Product product = new Product(1,"ada",1,1,100);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/getAvgPrice")
    public ResponseEntity<?> getAvgPrice() {
        return productService.getAvgPrice(1);
    }


    @GetMapping("/getListQtyPurchased")
    public ResponseEntity<?> getListQtyPurchased() {
        return productService.getListQtyPurchased();
    }

}
