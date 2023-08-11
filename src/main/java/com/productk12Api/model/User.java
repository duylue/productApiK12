package com.productk12Api.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int uid;
    private String name;

    private String username;

    private String password;

    private List<Role> roles;
}
