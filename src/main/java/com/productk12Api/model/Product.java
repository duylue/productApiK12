package com.productk12Api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    private int sid;
    private float price;

    @ManyToOne
    @JoinColumn(name = "cid")
    @JsonIgnore
    private Category category;
}
