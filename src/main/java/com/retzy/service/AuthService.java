package com.retzy.service;

import com.retzy.exceptions.UserException;
import com.retzy.payload.dto.UserDTO;
import com.retzy.payload.response.AuthResponse;

public interface AuthService {

    AuthResponse signup(UserDTO userDTO) throws UserException;
    AuthResponse login(UserDTO userDTO) throws UserException;
}
