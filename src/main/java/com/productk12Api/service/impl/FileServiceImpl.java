package com.productk12Api.service.impl;

import com.productk12Api.base.BaseResponse;
import com.productk12Api.model.MyFile;
import com.productk12Api.repository.FileRepo;
import com.productk12Api.service.FileService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class FileServiceImpl extends BaseResponse implements FileService {
    final private FileRepo fileRepo;

    public FileServiceImpl(FileRepo fileRepo) {
        this.fileRepo = fileRepo;
    }

    @Override
    public ResponseEntity<?> save(MultipartFile file, int id) {
        Optional<MyFile> optionalMyFile = fileRepo.findById(id);
        MyFile myFile = new MyFile();

        try {
            if (optionalMyFile.isEmpty()) {
                myFile.setId(id);
                myFile.setCtype(file.getContentType());
                myFile.setContent(file.getBytes());
                myFile.setFname(file.getOriginalFilename());
                fileRepo.save(myFile);
            } else {
                optionalMyFile.get().setId(id);
                optionalMyFile.get().setCtype(file.getContentType());
                optionalMyFile.get().setContent(file.getBytes());
                optionalMyFile.get().setFname(file.getOriginalFilename());
                fileRepo.save(optionalMyFile.get());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return getResponseEntity("success");
    }

    private MyFile convertMyFile(MultipartFile file, int id) {

        try {
            MyFile myFile = new MyFile();
            myFile.setId(id);
            myFile.setCtype(file.getContentType());
            myFile.setContent(file.getBytes());
            myFile.setFname(file.getOriginalFilename());
            return myFile;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<?> findByID(int id) {
        Optional<MyFile> file = fileRepo.findById(id);
        if (file.isEmpty()) {
            file = fileRepo.findById(2);
        }
        return ResponseEntity.status(200).
                contentType(MediaType.parseMediaType(file.get().getCtype()))
                .body(file.get().getContent());
    }
}
