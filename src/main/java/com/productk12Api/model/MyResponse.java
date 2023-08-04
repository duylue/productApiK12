package com.productk12Api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MyResponse {
    private int status;
    private String message;
    private Object data;

}
