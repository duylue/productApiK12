package com.productk12Api.repository;

import com.productk12Api.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class RoleRepoTest {
    @Autowired
    private RoleRepo repo;


    @Test
    void existsByRname() {
        Role role = new Role();
        String rname = "ROLE_CREATE88";
        role.setRname(rname);
        Role role1 = repo.save(role);
        assertThat(role1.getRname()).isEqualTo(rname);

    }
}