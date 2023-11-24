package com.gabriel.api.usermanagement.services;

import com.gabriel.api.usermanagement.dto.RolDTO;
import com.gabriel.api.usermanagement.dto.UserDetailDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {

    public RolDTO saveRol(RolDTO dto);

    public List<RolDTO> listRoles();
    public Optional<RolDTO> getRolById(Integer id);

    public void deleteRol(Integer id);

}
