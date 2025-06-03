package com.example.service;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    //TODO Переделать сигнатуру на Entity
    @Override
    public User createUser(String email, String password, Role role) {

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);



        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void removeUser(Long userId) {
        userRepository.removeUserById(userId);

    }
}
