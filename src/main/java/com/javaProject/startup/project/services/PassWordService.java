package com.javaProject.startup.project.services;

public interface PassWordService {
    String applyCryptography(String password);
    Boolean verifyCriptography(String password);
    Boolean verifyRules(String password);
}
