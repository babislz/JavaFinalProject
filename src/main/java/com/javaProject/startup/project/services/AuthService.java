package com.javaProject.startup.project.services;

import com.javaProject.startup.project.model.User;

public interface AuthService {
    User login(String username, String password);
}
