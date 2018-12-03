package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UsersViewModel;

import java.util.List;
import java.util.Optional;

public interface UsersDataService {
    List<UsersViewModel> getAll();
    
    Optional<UsersViewModel> getUsersById(int id);
    
    UsersViewModel saveUsers(UsersViewModel user);
    
    void deleteUsers(int id);
    
    UsersViewModel findByLogin(String name);
}
