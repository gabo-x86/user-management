package com.gabriel.api.usermanagement.services;

import com.gabriel.api.usermanagement.dto.UserDetailDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public UserDetailDTO save(UserDetailDTO user);

    public List<UserDetailDTO> listUsers();

    public List<UserDetailDTO> listUsersDetailed();

    public void deleteUser(Integer id);

    public Optional<UserDetailDTO> getUserById(Integer id);

    public List<UserDetailDTO> listUsersByRol(String rol);
}
