package com.productk12Api.repository;

import com.productk12Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsByUid(int id);
    User findByUsername(String username);
}
