package com.productk12Api.service;

import com.productk12Api.model.Customer;
import com.productk12Api.model.Product;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<?> getListCustomer();
    ResponseEntity<?> getListCustomerPaging(int page,int size, String propSortName);
    ResponseEntity<?> save(Customer customer);
    ResponseEntity<?> delete(int id);
    ResponseEntity<?> findById(int id);
    ResponseEntity<?> getListPurchased();
}

