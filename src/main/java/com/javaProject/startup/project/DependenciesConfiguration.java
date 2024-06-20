package com.javaProject.startup.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.javaProject.startup.project.impl.MockDepartmentService;
import com.javaProject.startup.project.impl.MockServicesService;
import com.javaProject.startup.project.impl.MockUserService;
import com.javaProject.startup.project.services.DepartmentService;
import com.javaProject.startup.project.services.ServiceService;
import com.javaProject.startup.project.services.UserService;

@Configuration
public class DependenciesConfiguration {

    @Bean @Scope()
    DepartmentService departamentService(){
        return new MockDepartmentService();
        //return new DBDepartmentService();
    }

    @Bean @Scope()
    UserService userService(){
        return new MockUserService();
        //return new DBUserService();
    }

    @Bean @Scope()
    ServiceService serviceService(){
        return new MockServicesService();
        //return new DBServicesService();
    }


}