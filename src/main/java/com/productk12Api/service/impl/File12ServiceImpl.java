package com.productk12Api.service.impl;

import com.productk12Api.base.BaseResponse;
import com.productk12Api.model.File12;
import com.productk12Api.repository.File12Repository;
import com.productk12Api.service.File12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;

@Service
public class File12ServiceImpl extends BaseResponse implements File12Service {
    @Autowired
    private File12Repository repository;

    @Override
    @Transactional
    public ResponseEntity<?> save(MultipartFile multipartFile, int uid) {
        if (repository.existsByUid(uid)) {
            repository.deleteByUid(uid);
        }
        repository.save(convertFile(multipartFile, uid));
        return getResponseEntity("success");
    }


    @Override
    public ResponseEntity<?> findByUid(int uid) {
        File12 file12 = repository.findByUid(uid);
        if (file12 == null) {
            file12 = repository.findByUid(121);
        }
        return getResponseEntityFile(file12);
    }
}
