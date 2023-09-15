package com.productk12Api.service;

import com.productk12Api.model.File12;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface File12Service {
    ResponseEntity<?> save(MultipartFile multipartFile , int uid);

    ResponseEntity<?> findByUid(int uid);
}
