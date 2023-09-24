package com.productk12Api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productk12Api.base.BaseResponse;
import com.productk12Api.model.Product;
import com.productk12Api.model.ProductDto;
import com.productk12Api.repository.ProductRepo;
import com.productk12Api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> getAvgPrice(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductDto productDto = objectMapper.convertValue(productRepo.getAvgPrice(id), ProductDto.class);
        return getResponseEntity(productDto);
    }

    @Override
    public ResponseEntity<?> findById(int id) {
        Product product = productRepo.findById(id).get();

        return getResponseEntity(product);
    }

    @Override
    public ResponseEntity<?> getListQtyPurchased() {
        List<Map<String,Object>> maps = productRepo.getListQtyPurchasedMap();
        return getResponseEntity(maps);
    }

    public int cul(int x, int y){
        return x *y;
    }

}
