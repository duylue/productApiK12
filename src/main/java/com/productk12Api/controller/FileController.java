package com.productk12Api.controller;

import com.productk12Api.model.File12;
import com.productk12Api.service.File12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/file")
public class FileController {
    @Autowired
    private File12Service service;

    @GetMapping
    public ResponseEntity<?> getFile(@RequestParam int id){
        return service.findByUid(id);
    }


    @PostMapping
    public ResponseEntity<?> saveFile(@RequestParam int id, @RequestParam MultipartFile file){
        return service.save(file,id);
    }


}
