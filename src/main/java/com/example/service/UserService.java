package com.example.service;

public interface UserService {

    void createUser(String email, String password, String role);

    void removeUser(Long userId);
}
