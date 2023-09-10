package com.productk12Api.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class MyFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fid;
    private String ctype;
    private String fname;
    @Column(length = 50000000)
    private byte [] content;
    private int id;



}
