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
        userDTO.setUpdatedAt(savedUser.getUpdatedAt());
        userDTO.setLastLogin(savedUser.getLastLogin());
        userDTO.setStoreId(savedUser.getStore()!=null? savedUser.getStore().getId():null);
        userDTO.setBranchId(savedUser.getBranch()!=null? savedUser.getBranch().getId():null);

        return userDTO;
    }

    public static User toEntity(UserDTO userDTO){
        User createdUser = new User();
        createdUser.setEmail(userDTO.getEmail());
        createdUser.setFullName(userDTO.getFullName());
        createdUser.setRole(userDTO.getRole());
        createdUser.setCreatedAt(userDTO.getCreatedAt());
        createdUser.setUpdatedAt(userDTO.getUpdatedAt());
        createdUser.setLastLogin(userDTO.getLastLogin());
        createdUser.setPhone(userDTO.getPhone());
        createdUser.setPassword(userDTO.getPassword());

        return createdUser;
    }
}
