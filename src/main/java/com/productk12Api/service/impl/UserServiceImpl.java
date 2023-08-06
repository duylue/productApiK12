package com.productk12Api.service.impl;

import com.productk12Api.base.BaseResponse;
import com.productk12Api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl extends BaseResponse {


    public ResponseEntity<?> get(){
        WebClient client = WebClient.create("http://localhost:8080");
        User userMono = client.get()
                .uri("/api/user")
                .retrieve()
                .bodyToMono(User.class).block();

        return getResponseEntity(userMono);
    }

}
