package com.gabriel.api.usermanagement.services.mapper;

import com.gabriel.api.usermanagement.domain.entities.Rol;
import com.gabriel.api.usermanagement.dto.RolDTO;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements CustomMapper<RolDTO, Rol>{

    @Override
    public RolDTO toDTO(Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setName(rol.getName());

        return dto;
    }

    @Override
    public Rol toEntity(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setName(rolDTO.getName());

        return rol;
    }
}
