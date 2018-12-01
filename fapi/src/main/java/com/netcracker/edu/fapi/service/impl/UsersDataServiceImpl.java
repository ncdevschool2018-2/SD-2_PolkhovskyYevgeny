package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.UsersViewModel;
import com.netcracker.edu.fapi.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service(value = "usersDataServiceImpl")
public class UsersDataServiceImpl implements UsersDataService, UserDetailsService {
    
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;
    
    @Override
    public List<UsersViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UsersViewModel[] usersViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/users/all", UsersViewModel[].class);
        return usersViewModelResponse == null ? Collections.emptyList() : Arrays.asList(usersViewModelResponse);
    }
    
    @Override
    public Optional<UsersViewModel> getUsersById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/users/" + id, Optional.class);
    }
    
    
    @Override
    public UsersViewModel saveUsers(UsersViewModel user) {
        RestTemplate restTemplate = new RestTemplate();
        UsersViewModel newUser= new UsersViewModel(user.getLogin(),bcryptEncoder.encode(user.getPassword()),user.getRoleId());
        return restTemplate.postForEntity(backendServerUrl + "/api/users", newUser,
                UsersViewModel.class).getBody();
    }
    
    @Override
    public void deleteUsers(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/users/" + id);
        
    }
    
    @Override
    public UsersViewModel findByLogin(String name) {
        RestTemplate restTemplate = new RestTemplate();
        
        return restTemplate.getForObject(backendServerUrl + "/api/users/login/" + name, UsersViewModel.class);
    }
    
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UsersViewModel user = findByLogin(name);
    
    
    
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthority(user));
    }
    private Set<GrantedAuthority> getAuthority(UsersViewModel user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority( Integer.toString(user.getRoleId())));
        return authorities;
    }
}
