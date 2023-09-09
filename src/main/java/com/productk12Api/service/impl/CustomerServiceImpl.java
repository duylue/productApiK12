package com.productk12Api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productk12Api.base.BaseResponse;
import com.productk12Api.model.Customer;
import com.productk12Api.model.CustomerDTO;
import com.productk12Api.repository.CustomerRepository;
import com.productk12Api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl extends BaseResponse implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity<?> getListCustomer() {

        return getResponseEntity(customerRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getListCustomerPaging(int page, int size, String propSortName) {
        Pageable pageable = PageRequest.of(page, size,
                Sort.by(Sort.Direction.ASC, propSortName));
        Page<Customer> pageCus = customerRepository.findAll(pageable);

        return getResponseEntity(pageCus);
    }

    @Override
    public ResponseEntity<?> save(Customer customer) {
        return getResponseEntity(customerRepository.save(customer));
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        return null;
    }

    @Override
    public ResponseEntity<?> findById(int id) {
        return getResponseEntity(customerRepository.findById(id));
    }

    @Override
    public ResponseEntity<?> search(int key, String value) {

        switch (key) {
            case 1:
                return getResponseEntity(customerRepository.findByCusnameIgnoreCase(value));
            case 2:
                return getResponseEntity(customerRepository.findByPhoneIgnoreCase(value));

            case 3:
                return getResponseEntity(customerRepository.findByAidIgnoreCase(Integer.parseInt(value)));
        }
        return null;

    }

    @Override
    public ResponseEntity<?> getListPurchased() {
        List<Map<String, Object>> maps = customerRepository.getListPurchasedMap();
        ObjectMapper objectMapper = new ObjectMapper();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Map m : maps) {
            CustomerDTO customerDTO = objectMapper.convertValue(m, CustomerDTO.class);
            customerDTOList.add(customerDTO);
        }


        return getResponseEntity(customerDTOList);
    }
}
