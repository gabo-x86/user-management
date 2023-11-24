package com.gabriel.api.usermanagement.services.implement;

import com.gabriel.api.usermanagement.domain.entities.UserRol;
import com.gabriel.api.usermanagement.repositories.UserRolRepository;
import com.gabriel.api.usermanagement.services.UserRolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserRolServiceImpl implements UserRolService {
    //private static final Logger log = LoggerFactory.getLogger(UserRolServiceImpl.class);
    private final UserRolRepository userRolRepository;

    public UserRolServiceImpl(UserRolRepository userRolRepository) {
        this.userRolRepository = userRolRepository;
    }

    @Override
    public List<UserRol> getEnrollmentByUserId(Integer userId, boolean activated) {
        return this.userRolRepository.findAllByUserId(userId, activated);
    }

    @Override
    public UserRol saveUserRol(UserRol userRol) {
        return this.userRolRepository.save(userRol);
    }

    @Override
    public UserRol disableUserRol(Integer userId, Integer rolId){
        UserRol userRol = this.userRolRepository.findByUserIdAndRolId(userId, rolId);
        userRol.setActive(false);
        return userRol;
    }
}
