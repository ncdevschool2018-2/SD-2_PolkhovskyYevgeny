package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Users;

import java.util.Optional;

public interface UsersService {
    Users saveUsers(Users users);
    Optional<Users> getUsersById(int id);
    Iterable<Users> getAllUsers();
    void deleteUsers(int id);
    Users findUserByLogin(String login);
    
}
