package com.javaProject.startup.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.javaProject.startup.project.model.Department;
import com.javaProject.startup.project.model.Roles;
import com.javaProject.startup.project.model.User;
import com.javaProject.startup.project.services.UserService;

public class UserTest {

    @Autowired
	UserService userService;

    @BeforeEach
    public void setUp() {
        //não esquecer de verificar se precisa de configurações adicionais
    }

    @Test
    public void testCreateUser() {
        String username = "newuser";
        String password = "password123";
        Department department = new Department(); 
        Roles role = Roles.EMPLOYEE; 

        User newUser = userService.create(username, password, department, role);

        assertNotNull(newUser);
        assertEquals(username, newUser.getUsername());
        assertEquals(department, newUser.getDepartment());
        assertEquals(role, newUser.getRole());
    }

    @Test
    public void testUpdatePassword() {
        Long userId = 1L; 
        String newPassword = "newPassword123";

        String result = userService.updatePassword(userId, newPassword);

        assertEquals("Password updated successfully.", result);

        User updatedUser = userService.Get("trevisharp");
        assertEquals(newPassword, updatedUser.getPassword());
    }

    @Test
    public void testGetUserByUsername() {
        String username = "trevisharp";

        User user = userService.Get(username);

        assertNotNull(user);
        assertEquals(username, user.getUsername());
    }

    @Test
    public void testGetUserByUsername_NotFound() {
        String username = "nonexistentuser";

        User user = userService.Get(username);

        assertNull(user);
    }
}
