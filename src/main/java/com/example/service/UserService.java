package com.example.service;

import com.example.entity.Role;
import com.example.entity.User;

public interface UserService {

    User createUser(String email, String password, Role role);
}
