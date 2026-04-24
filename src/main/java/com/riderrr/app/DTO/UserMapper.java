package com.riderrr.app.DTO;

import com.riderrr.app.Entity.Branch;
import com.riderrr.app.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User toEntity(UserRequestDTO dto, Branch branch){

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setBranch(branch);
        user.setAddress(dto.getAddress());

        return user;
    }

    public static  UserResponseDTO toDTO(User user){

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole().name());

        if(user.getBranch() != null){
            dto.setBranch(user.getBranch().getId());
        }

        dto.setAddress(user.getAddress());

        return dto;
    }
}
