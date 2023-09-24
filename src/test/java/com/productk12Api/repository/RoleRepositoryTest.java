package com.productk12Api.repository;

import com.productk12Api.model.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRepositoryTest {
    @Autowired
    RoleRepository roleRepository;

    @AfterEach
    void delAll() {
        roleRepository.deleteAll();
    }

    @Test
    void saveTest() {
        String rName = "ROLE_CREATE";
        Role role = new Role();
        role.setRname(rName);
        Role role1 = roleRepository.save(role);
        assertThat(role1.getRname()).isEqualTo(rName);

    }


}