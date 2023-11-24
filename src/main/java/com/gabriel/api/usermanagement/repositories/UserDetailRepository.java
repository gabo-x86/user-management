package com.gabriel.api.usermanagement.repositories;

import com.gabriel.api.usermanagement.domain.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
}
