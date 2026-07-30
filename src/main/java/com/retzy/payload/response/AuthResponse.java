package com.retzy.payload.response;

import com.retzy.payload.dto.UserDTO;
import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;
    private String message;
    private UserDTO user;

}
