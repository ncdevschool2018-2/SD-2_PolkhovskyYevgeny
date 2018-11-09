package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UsersViewModel;
import org.apache.catalina.User;

import java.util.List;

public interface UsersDataService {
    List<UsersViewModel> getAll();
    UsersViewModel getUsersById(Long id);
    
    UsersViewModel saveUsers(UsersViewModel user);
    void deleteUsers(Long id);
}
