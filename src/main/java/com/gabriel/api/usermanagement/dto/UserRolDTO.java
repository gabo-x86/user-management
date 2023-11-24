package com.gabriel.api.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//To save user rol
@Getter
@Setter
@ToString
public class UserRolDTO {
    private Integer id;
    private String username;
    private String password;
    private String email;

    private String name;

    public UserRolDTO(){

    }

}
