package com.productk12Api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping
    public ResponseEntity<?> test() {
        return ResponseEntity.status(200).body("Test");
    }


}
