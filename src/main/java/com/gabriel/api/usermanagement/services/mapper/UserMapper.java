package com.gabriel.api.usermanagement.services.mapper;

import com.gabriel.api.usermanagement.domain.entities.User;
import com.gabriel.api.usermanagement.dto.UserDetailDTO;
import org.springframework.stereotype.Component;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class UserMapper implements CustomMapper<UserDetailDTO, User>{
    @Override
    public UserDetailDTO toDTO(User user) {
        UserDetailDTO dto = new UserDetailDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());

        return dto;
    }
    public UserDetailDTO toDTODetailed(User user) {
        UserDetailDTO dto = new UserDetailDTO();
        dto.setUsername(user.getUsername());
        dto.setId(user.getId());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());

        if(user.getUserDetail() != null){
            dto.setFirstName(user.getUserDetail().getFirstName());
            dto.setLastName(user.getUserDetail().getLastName());
            dto.setAge(user.getUserDetail().getAge());
            dto.setBirthDay(user.getUserDetail().getBirthDay().toString());
        }

        return dto;
    }

    @Override
    public User toEntity(UserDetailDTO userDetailDTO) {
        User user = new User();
        user.setId(userDetailDTO.getId());
        user.setUsername(userDetailDTO.getUsername());
        user.setPassword(userDetailDTO.getPassword());
        user.setEmail(userDetailDTO.getEmail());
        user.setCreatedAt(userDetailDTO.getCreatedAt());

        return user;
    }
}
