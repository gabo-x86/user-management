package com.gabriel.api.usermanagement.repositories;

import com.gabriel.api.usermanagement.domain.entities.Rol;
import com.gabriel.api.usermanagement.domain.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RolRepository extends JpaRepository<Rol, Integer> {

}
