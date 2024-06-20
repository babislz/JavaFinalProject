package com.javaProject.startup.project.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaProject.startup.project.model.Roles;
import com.javaProject.startup.project.model.User;
import com.javaProject.startup.project.services.UserService;

import jakarta.annotation.PostConstruct;

import com.javaProject.startup.project.model.Department;

@Service
// Implementação de um serviço fictício de usuário
public class MockUserService implements UserService {

    private List<User> users = new ArrayList<>(); // Lista para armazenar os usuários

    @Autowired
    MockDepartmentService mockDepartmentService;

    // Construtor que inicializa alguns usuários fictícios com base nos departamentos obtidos do MockDepartmentService
    @PostConstruct
    public void init()
    {
        List<Department> departments = mockDepartmentService.getAll();

        // Criação e inicialização de três usuários fictícios com diferentes papéis e departamentos
        var user1 = new User();
        user1.setId(1L);
        user1.setUsername("trevisharp");
        user1.setPassword("123456");
        user1.setRole(Roles.ADMINISTRATOR);
        user1.setDepartment(departments.get(0));
        users.add(user1);

        var user2 = new User();
        user2.setId(2L);
        user2.setUsername("isaJK");
        user2.setPassword("222555");
        user2.setRole(Roles.EMPLOYEE);
        user2.setDepartment(departments.get(1));
        users.add(user2);

        var user3 = new User();
        user3.setId(3L);
        user3.setUsername("loregbr");
        user3.setPassword("555555");
        user3.setRole(Roles.EMPLOYEE);
        user3.setDepartment(departments.get(2));
        users.add(user3);
    }
    
    // Método da interface UserService para criar um novo usuário
    @Override
    public User create(String username, String password, Department department, Roles role) {
        var newUser = new User();
        newUser.setId((long) (users.size() + 1));
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);
        newUser.setDepartment(department);

        users.add(newUser);

        return newUser;
    }

    // Método da interface UserService para atualizar a senha de um usuário
    @Override
    public String updatePassword(Long id, String newPassword) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setPassword(newPassword);
                return "Password updated successfully.";
            }
        }
        return "User not found.";
    }

    // Método da interface UserService para obter um usuário pelo nome de usuário
    @Override
    public User Get(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}