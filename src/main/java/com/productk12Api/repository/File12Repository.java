package com.productk12Api.repository;

import com.productk12Api.model.File12;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface File12Repository  extends JpaRepository<File12,Integer> {
    File12 findByUid(int uid);
    void deleteByUid(int uid);
    Boolean existsByUid(int uid);
}
