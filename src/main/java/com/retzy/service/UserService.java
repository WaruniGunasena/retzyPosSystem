package com.retzy.service;

import com.retzy.exceptions.UserException;
import com.retzy.model.User;

import java.util.List;

public interface UserService {

    User getUserFromJwtToken(String token) throws UserException;
    User getCurrentUser() throws UserException;
    User getUserByEmail(String email) throws UserException;
    User getUserById(Long id);
    List<User> getAllUsers();



}
