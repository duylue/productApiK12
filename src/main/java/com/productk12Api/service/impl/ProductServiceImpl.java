package com.productk12Api.service.impl;

import com.productk12Api.base.BaseResponse;
import com.productk12Api.model.Product;
import com.productk12Api.repository.CategoryRepo;
import com.productk12Api.repository.ProductRepo;
import com.productk12Api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends BaseResponse implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ResponseEntity<?> getListProduct() {
        List<Product> products = productRepo.findAll();
        return getResponseEntity(products);
    }

    @Override
    public ResponseEntity<?> save(Product product) {
        Product product1 = productRepo.save(product);
        return getResponseEntity(product1);
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        productRepo.deleteById(id);
        return getResponseEntity("Xoa Thanh Cong");
    }

    @Override
    public ResponseEntity<?> findById(int id) {
        Product product = productRepo.findById(id).get();
        return getResponseEntity(product);
    }

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public ResponseEntity<?> findCtById(int id) {
        return getResponseEntity(categoryRepo.findById(id).get());
    }

    @Override
    public int test(int x, int y) {
        return x+y;
    }
}
