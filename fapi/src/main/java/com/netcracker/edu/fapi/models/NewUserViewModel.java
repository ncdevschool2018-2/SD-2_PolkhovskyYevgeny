package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewUserViewModel {
    
    private String name;
    private String surname;
    private int subjectId;
    private int groupId;
    private int userId;
    private String login;
    private String password;
    private int roleId;
    
    
    public NewUserViewModel() {
    }
    
    
    public NewUserViewModel(String name, String surname, int subjectId, int groupId, int userId, String login, String password, int roleId) {
        this.name = name;
        this.surname = surname;
        this.subjectId = subjectId;
        this.groupId = groupId;
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }
    
    
    public int getSubjectId() {
        return subjectId;
    }
    
    
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    
    
    public String getName() {
        return name;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public String getSurname() {
        return surname;
    }
    
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
    public int getGroupId() {
        return groupId;
    }
    
    
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    
    
    public int getUserId() {
        return userId;
    }
    
    
    public void setUserId(int userId) {
        this.userId = userId;
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
