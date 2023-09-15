package com.productk12Api.base;

import com.productk12Api.model.File12;
import com.productk12Api.model.MyResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class BaseResponse {
    protected ResponseEntity<?> getResponseEntity(Object data) {
        return ResponseEntity.ok(getResponse(data));

    }


    protected ResponseEntity<?> getResponseEntityFile(File12 file12) {
        return ResponseEntity.status(200).contentType(MediaType
                        .parseMediaType(file12.getCtype()))
                .body(file12.getContent());

    }

    protected File12 convertFile(MultipartFile file, int uid) {
        File12 file12 = new File12();
        try {
            file12.setFname(file.getOriginalFilename());
            file12.setCtype(file.getContentType());
            file12.setUid(uid);
            file12.setContent(file.getBytes());
            return file12;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }


    private MyResponse getResponse(Object data) {
        MyResponse myResponse = new MyResponse();
        myResponse.setData(data);
        myResponse.setStatus(200);
        myResponse.setMessage("success");
        return myResponse;
    }

}
