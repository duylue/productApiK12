package com.productk12Api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    @Column(unique = true)
    private String username;
    private String password;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(joinColumns = {@JoinColumn(name = "uid",referencedColumnName = "uid")},
    inverseJoinColumns = {@JoinColumn(name = "rid",referencedColumnName = "rid")})
    private List<Role> roles;

}
