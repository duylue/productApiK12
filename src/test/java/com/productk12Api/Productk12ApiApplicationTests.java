package com.productk12Api;

import com.productk12Api.service.ProductService;
import com.productk12Api.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class Productk12ApiApplicationTests {
ProductServiceImpl productService = new ProductServiceImpl();

    @Test
    void contextLoads() {
    }

	@Test
	void productServiceTest(){
		int x = 10;
		int y = 11;
		int actualRs = productService.test(x,y);
		int exRs = 33;
		assertThat(actualRs).isEqualTo(exRs);
	}

}
