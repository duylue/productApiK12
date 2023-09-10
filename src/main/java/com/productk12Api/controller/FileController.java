package com.productk12Api.controller;

import com.productk12Api.model.MyFile;
import com.productk12Api.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;

    }

    @PostMapping("/save")
    public ResponseEntity<?> saveFile(@RequestParam MultipartFile file,
                                      @RequestParam int id) {
        return fileService.save(file, id);
    }
}
