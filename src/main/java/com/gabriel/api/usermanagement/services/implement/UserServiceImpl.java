package com.gabriel.api.usermanagement.services.implement;

import com.gabriel.api.usermanagement.domain.entities.User;
import com.gabriel.api.usermanagement.domain.entities.UserDetail;
import com.gabriel.api.usermanagement.dto.UserDetailDTO;
import com.gabriel.api.usermanagement.repositories.UserDetailRepository;
import com.gabriel.api.usermanagement.repositories.UserRepository;
import com.gabriel.api.usermanagement.services.UserService;
import com.gabriel.api.usermanagement.services.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserDetailRepository userDetailRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserDetailRepository userDetailRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userDetailRepository = userDetailRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetailDTO save(UserDetailDTO dto) {
        dto.setPassword(this.passwordEncoder.encode(dto.getPassword()));
        User user = this.userRepository.save(this.userMapper.toEntity(dto));

        if(dto.getFirstName() != null && dto.getLastName() != null){
            UserDetail userDetail = new UserDetail();
            if(dto.getAge() != null) userDetail.setAge(dto.getAge());
            if(dto.getBirthDay() != null){
                userDetail.setBirthDay(
                        LocalDate.parse(
                                dto.getBirthDay(),
                                DateTimeFormatter.ofPattern("MM-dd-yyyy")
                        )
                );
            }
            //These two fields must to be non-null
            userDetail.setFirstName(dto.getFirstName());
            userDetail.setLastName(dto.getLastName());
            userDetail.setUser(user);
            this.userDetailRepository.save(userDetail);
        }

        dto.setId(user.getId());
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailDTO> listUsers() {
        return this.userRepository.findAll()
                .stream()
                .map(this.userMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailDTO> listUsersDetailed() {
        return this.userRepository.findAll()
                .stream()
                .map(this.userMapper::toDTODetailed)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer id) {
        this.userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDetailDTO> getUserById(Integer id) {
        return this.userRepository.findById(id)
                .map(this.userMapper::toDTODetailed);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailDTO> listUsersByRol(String rol) {
        return this.userRepository.getUserByRolName(rol)
                .stream()
                .map(this.userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetailDTO edit(UserDetailDTO dto) {
        User prevUser = this.userRepository.findById((Integer) dto.getId()).get();
        User user = this.userMapper.toEntity(dto);
        if(prevUser.getCreatedAt() != null) user.setCreatedAt(prevUser.getCreatedAt());
        if(prevUser.getUserDetail() != null) user.setUserDetail(prevUser.getUserDetail());
        if(prevUser.getAssignations() != null) user.setAssignations(prevUser.getAssignations());

        User userEdited = this.userRepository.save(user);


        if(dto.getFirstName() != null && dto.getLastName() != null){
            UserDetail userDetail = new UserDetail();
            if(dto.getAge() != null) userDetail.setAge(dto.getAge());
            if(dto.getBirthDay() != null){
                userDetail.setBirthDay(
                        LocalDate.parse(
                                dto.getBirthDay(),
                                DateTimeFormatter.ofPattern("MM-dd-yyyy")
                        )
                );
            }
            if(user.getUserDetail() != null){
                userDetail.setId(user.getUserDetail().getId());
            }
            userDetail.setFirstName(dto.getFirstName());
            userDetail.setLastName(dto.getLastName());
            userDetail.setUser(user);
            this.userDetailRepository.save(userDetail);
        }

        dto.setId(user.getId());
        return dto;
    }
}
