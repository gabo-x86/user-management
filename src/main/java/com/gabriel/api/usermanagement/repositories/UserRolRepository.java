package com.gabriel.api.usermanagement.repositories;

import com.gabriel.api.usermanagement.domain.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRolRepository extends JpaRepository<UserRol, Integer> {

    @Query("SELECT ur " +
            "FROM UserRol ur " +
            "WHERE ur.user.id=:userId AND ur.active=:activated")
    public List<UserRol> findAllByUserId(Integer userId, boolean activated);

    @Query("SELECT ur " +
            "FROM UserRol ur " +
            "WHERE ur.user.id=:userId AND ur.rol.id=:rolId AND ur.active=true")
    public UserRol findByUserIdAndRolId(Integer userId, Integer rolId);

}
