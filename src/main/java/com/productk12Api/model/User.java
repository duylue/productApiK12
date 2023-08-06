package com.productk12Api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class User {
    private int uid;
    private String name;

    private String username;

    private String password;

    private List<Role> roles;
}
