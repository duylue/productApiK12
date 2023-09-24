package com.productk12Api;

import com.productk12Api.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class Productk12ApiApplicationTests {
    @Autowired
    ProductServiceImpl service;

    @Test
    void contextLoads() {


    }
    @Test
    void tinhtich(){
        int x = 10;
        int y = 10;

        int expectedRs = 101;
        int actualRs = service.cul(x,y);


        assertThat(actualRs).isEqualTo(expectedRs);
    }

}
