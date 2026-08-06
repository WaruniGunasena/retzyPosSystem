package com.retzy.service;

import com.retzy.domain.UserRole;
import com.retzy.model.User;
import com.retzy.payload.dto.UserDTO;

import java.util.List;

public interface EmployeeService {

    UserDTO createStoreEmployee(UserDTO employee, Long storeId) throws Exception;
    UserDTO createBranchEmployee(UserDTO employee, Long branchId) throws Exception;
    User updateEmployee(Long employeeId, UserDTO employeeDetails) throws Exception;
    void deleteEmployee(Long employeeId) throws Exception;
    List<User> findStoreEmployees(Long storeId, UserRole role) throws Exception;
    List<User> findBranchEmployees(Long branchId, UserRole role) throws Exception;
}
