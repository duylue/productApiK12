package com.productk12Api.service.impl;

import com.productk12Api.base.BaseResponse;
import com.productk12Api.model.MyFile;
import com.productk12Api.repository.FileRepo;
import com.productk12Api.service.FileService;
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
        fileRepo.save(convertMyFile(file,id));

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
        if (file.isEmpty()){
            throw new RuntimeException("file invalid");
        }
        return getResponseEntity(file.get());
    }
}
