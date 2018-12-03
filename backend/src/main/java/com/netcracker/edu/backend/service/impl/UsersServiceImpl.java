package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Users;
import com.netcracker.edu.backend.repository.UsersRepository;
import com.netcracker.edu.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {
    
    private UsersRepository repository;
    
    
    @Autowired
    public UsersServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }
    
    
    @Override
    public Users saveUsers(Users users) {
        
        return repository.save(users);
    }
    
    
    @Override
    public Optional<Users> getUsersById(int id) {
        return repository.findById(id);
    }
    
    
    @Override
    public Iterable<Users> getAllUsers() {
        return repository.findAll();
    }
    
    
    @Override
    public void deleteUsers(int id) {
        repository.deleteById(id);
    }
    
    
    @Override
    public Users findUserByLogin(String login) {
        
        
        return repository.findUserByLogin(login);
    }
    
    
}
