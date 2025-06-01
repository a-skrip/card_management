package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long userId);

    void deleteUserById(Long userId);

    //TODO Переделать на Entity
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (email, password, role) VALUES (:email, :password, :role)", nativeQuery = true)
    void createUser(@Param("email") String email,
                    @Param("password") String password,
                    @Param("role") String role);

}


