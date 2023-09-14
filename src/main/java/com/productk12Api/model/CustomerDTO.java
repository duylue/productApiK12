package com.productk12Api.model;

import lombok.*;

import javax.persistence.Entity;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerDTO {
    private int cusid;
    private String cusname;
    private String phone;
    private String address;
    private int aid;
    private int oid;
    private Date odate;
    private Date birthday;
}
