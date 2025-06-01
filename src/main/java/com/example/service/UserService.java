package com.example.service;

public interface UserService {

    void createUser(String email, String password, String role);

    void deleteUser(Long userId);
}
