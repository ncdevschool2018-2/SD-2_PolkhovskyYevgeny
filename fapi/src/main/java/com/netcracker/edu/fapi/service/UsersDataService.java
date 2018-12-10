package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UsersChangeViewModel;
import com.netcracker.edu.fapi.models.UsersViewModel;

import java.util.List;

public interface UsersDataService {
    List<UsersViewModel> getAll();
    
    UsersViewModel getUsersById(int id);
    
    UsersViewModel saveUsers(UsersViewModel user);
    
    UsersViewModel saveChangeUsers(UsersChangeViewModel user);
    
    void deleteUsers(int id);
    
    UsersViewModel findByLogin(String name);
}
