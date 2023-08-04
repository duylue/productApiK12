package com.productk12Api.service;

import com.productk12Api.model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> getListProduct();
    ResponseEntity<?> save(Product product);
    ResponseEntity<?> delete(int id);
    ResponseEntity<?> findById(int id);
}
