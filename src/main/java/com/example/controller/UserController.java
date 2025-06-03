package com.example.controller;


import com.example.entity.Role;
import com.example.entity.User;
import com.example.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/new")
    public ResponseEntity<User> createUser(@RequestParam String email,
                                     @RequestParam String password,
                                     @RequestParam String role) {

        return ResponseEntity.ok(userService.createUser(email, password, Role.valueOf(role)));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
    }
}

