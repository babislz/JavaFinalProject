package com.javaProject.startup.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ServicesData")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "Intern")
    private Boolean intern;

    public Boolean getIntern() {
        return intern;
    }

    public void setIntern(Boolean intern) {
        this.intern = intern;
    }    

    
}
