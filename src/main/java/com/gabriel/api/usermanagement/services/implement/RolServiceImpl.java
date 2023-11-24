package com.gabriel.api.usermanagement.services.implement;

import com.gabriel.api.usermanagement.domain.entities.Rol;
import com.gabriel.api.usermanagement.dto.RolDTO;
import com.gabriel.api.usermanagement.repositories.RolRepository;
import com.gabriel.api.usermanagement.services.RolService;
import com.gabriel.api.usermanagement.services.mapper.RolMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    private final RolMapper rolMapper;

    public RolServiceImpl(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public RolDTO saveRol(RolDTO dto) {
        Rol rol = this.rolRepository.save(this.rolMapper.toEntity(dto));
        return this.rolMapper.toDTO(rol);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RolDTO> listRoles() {
        return this.rolRepository.findAll()
                .stream()
                .map(this.rolMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RolDTO> getRolById(Integer id) {
        return this.rolRepository.findById(id)
                .map(this.rolMapper::toDTO);
    }

    @Override
    public void deleteRol(Integer id) {
        this.rolRepository.deleteById(id);
    }
}
