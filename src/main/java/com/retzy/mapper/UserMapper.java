package com.retzy.mapper;

import com.retzy.model.User;
import com.retzy.payload.dto.UserDTO;

public class UserMapper {

    public static UserDTO toDTO(User savedUser) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(savedUser.getId());
        userDTO.setEmail(savedUser.getEmail());
        userDTO.setFullName(savedUser.getFullName());
        userDTO.setRole(savedUser.getRole());
        userDTO.setPhone(savedUser.getPhone());
        userDTO.setCreatedAt(savedUser.getCreatedAt());
        userDTO.setUpdateAt(savedUser.getUpdateAt());
        userDTO.setLastLogin(savedUser.getLastLogin());

        return userDTO;
    }
}
