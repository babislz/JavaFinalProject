package com.javaProject.startup.project.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "DepartmentsData")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    // One-to-Many relationship with users
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<User> users;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
