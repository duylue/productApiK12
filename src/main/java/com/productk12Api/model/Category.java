package com.productk12Api.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Category {
    @Id
    private int cid;
    private String cname;
    @OneToMany(mappedBy = "category")
    private List<Product> list;


}
