package com.gabriel.api.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

//To save User detail
@Getter
@Setter
@ToString
public class UserDetailDTO {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;//

    private String firstName;
    private String lastName;
    private Integer age;
    private String birthDay;

    public UserDetailDTO(){

    }

}
