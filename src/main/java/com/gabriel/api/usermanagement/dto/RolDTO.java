package com.gabriel.api.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//To save rol
@Getter
@Setter
@ToString
public class RolDTO {

    private Integer id;
    private String name;

    public RolDTO(){

    }
}
