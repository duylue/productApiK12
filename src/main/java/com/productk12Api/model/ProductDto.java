package com.productk12Api.model;

import lombok.*;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProductDto {
    private int pid;
    private int qty;
    private String pname;
    private float avg;
    private int cid;
    private String cname;
}
