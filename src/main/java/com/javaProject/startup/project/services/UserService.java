package com.javaProject.startup.project.services;

import com.javaProject.startup.project.model.Department;
import com.javaProject.startup.project.model.Roles;
import com.javaProject.startup.project.model.User;

public interface UserService {
    User create(String username, String password, Department department, Roles role);//arrumar
    String updatePassword(Long id, String newPassword);
    User Get(String username);
}
