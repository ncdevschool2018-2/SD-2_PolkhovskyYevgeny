package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.UsersViewModel;
import com.netcracker.edu.fapi.service.UsersDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UsersDataServiceImpl implements UsersDataService {
    
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    @Override
    public List<UsersViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UsersViewModel[] usersViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/users/all", UsersViewModel[].class);
        return usersViewModelResponse == null ? Collections.emptyList() : Arrays.asList(usersViewModelResponse);
    }
    
    @Override
    public UsersViewModel getUsersById(int id) {
        return null;
    }
    
    
    @Override
    public UsersViewModel saveUsers(UsersViewModel user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/users", user, UsersViewModel.class).getBody();
    }
    
    @Override
    public void deleteUsers(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/users/" + id);
        
    }
}
