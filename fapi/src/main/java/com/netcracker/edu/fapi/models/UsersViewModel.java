package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersViewModel {
    private int id;
    private String login;
    private String password;
    
    private int roleId;
    
    
    public UsersViewModel() {
    }
    
    public UsersViewModel(int id, String login, String password, int roleId) {
        this.id = id;
        this.login = login;
        this.password = password;
        
        this.roleId = roleId;
        
    }
    
    public UsersViewModel(String login, String password, int roleId) {
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public int getRoleId() {
        return roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
}
