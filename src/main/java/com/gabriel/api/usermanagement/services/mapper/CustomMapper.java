package com.gabriel.api.usermanagement.services.mapper;

public interface CustomMapper <DTO, E>{
    public DTO toDTO(E e);

    public E toEntity(DTO dto);
}
