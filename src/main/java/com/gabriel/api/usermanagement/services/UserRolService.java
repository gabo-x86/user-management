package com.gabriel.api.usermanagement.services;

import com.gabriel.api.usermanagement.domain.entities.UserRol;

import java.util.List;

public interface UserRolService {

    public List<UserRol> getEnrollmentByUserId(Integer userId, boolean activated);

    public UserRol saveUserRol(UserRol userRol);

    public UserRol disableUserRol(Integer userId, Integer rolId);

}
