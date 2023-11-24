package com.gabriel.api.usermanagement.repositories;

import com.gabriel.api.usermanagement.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u " +
            "FROM User u " +
            "JOIN u.assignations ur " +
            "JOIN ur.rol r " +
            "WHERE r.name = :rolName")
    public List<User> getUserByRolName(String rolName);
}
