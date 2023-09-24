package com.productk12Api.repository;

import com.productk12Api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

    boolean existsByRname(String name);
}
