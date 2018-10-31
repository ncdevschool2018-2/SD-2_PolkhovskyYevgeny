package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Users;

import java.util.Optional;

public interface UsersService {
    Users saveUsers(Users users);
    Optional<Users> getUsersById(Long id);
    Iterable<Users> getAllUsers();
    void deleteUsers(Long id);
}
