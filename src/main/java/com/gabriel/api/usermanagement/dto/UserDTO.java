package com.gabriel.api.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//To save User
@Getter
@Setter
@ToString
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String email;

    public UserDTO(){

    }
}
