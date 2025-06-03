package com.example.service;

import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    //TODO Переделать сигнатуру на Entity
    @Override
    public void createUser(String email, String password, String role) {
        userRepository.createUser(email, password, role);

    }

    @Override
    @Transactional
    public void removeUser(Long userId) {
        userRepository.removeUserById(userId);

    }
}
