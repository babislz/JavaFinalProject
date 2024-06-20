package com.javaProject.startup.project.services;

import java.util.List;

import com.javaProject.startup.project.model.Services;

public interface ServiceService {
    List<Services> Get(String query, Integer pageIndex, Integer pageSize);
}
