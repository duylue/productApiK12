package com.productk12Api.controller;

import com.productk12Api.model.Customer;
import com.productk12Api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return customerService.getListCustomer();
    }

    @GetMapping("/getListCustomerPaging")
    public ResponseEntity<?> getListCustomerPaging(@RequestParam int page,
                                                   @RequestParam int size,
                                                   @RequestParam String sort) {
        return customerService.getListCustomerPaging(page, size, sort);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(
            @RequestParam int key,
            @RequestParam String search) {
        return customerService.search(key, search);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/getListPurchased")
    public ResponseEntity<?> getListPurchased() {
        return customerService.getListPurchased();
    }

}
