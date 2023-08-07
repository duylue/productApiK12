package com.productk12Api.repository;

import com.productk12Api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select c.*, o.oid,o.odate from customer c , orders o\n" +
            "where c.cusid = o.cusid",nativeQuery = true)
    List<Map<String,Object>> getListPurchasedMap();

}
