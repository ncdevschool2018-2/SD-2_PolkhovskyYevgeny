package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.backend.entity.Users;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PupilViewModel {
    
    private int id;
    private String name;
    private String surname;
    private Users usersByUserId;
    private int groupId;
    private int userId;
    
    public PupilViewModel() {
    }
    
    public PupilViewModel(int id, String name, String surname, Users usersByUserId, int groupId, int userId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.usersByUserId = usersByUserId;
        this.groupId = groupId;
        this.userId = userId;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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
    
    public Users getUsersByUserId() {
        return usersByUserId;
    }
    
    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
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
}
