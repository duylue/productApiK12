package com.productk12Api.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    private int id;
    private String pname;
    private int cid;
    private int sid;
    private float price;
}
