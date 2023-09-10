package com.productk12Api.service;

import com.productk12Api.model.MyFile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    ResponseEntity<?> save(MultipartFile file, int id);
    ResponseEntity<?> findByID(int id);
}
