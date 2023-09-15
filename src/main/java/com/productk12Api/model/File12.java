package com.productk12Api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class File12 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int fid;
    public String fname;
    public String ctype;
    @Column(length = 50000000)
    public byte [] content;
    public int uid;

}
