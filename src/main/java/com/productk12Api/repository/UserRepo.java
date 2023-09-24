package com.productk12Api.repository;

import com.productk12Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo extends JpaRepository<User,Integer> {
    boolean existsByUsername(String username);

}
