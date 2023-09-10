package com.productk12Api.repository;

import com.productk12Api.model.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FileRepo extends JpaRepository<MyFile,Long> {
    Optional<MyFile> findById(int id);
}
