package com.example.controller;


import com.example.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/new")
    public void createUser(@RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String role) {

        userService.createUser(email, password, role);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
    }
}
