package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RolesViewModel {
    private int id;
    private String name;
    /*private Collection<Users> usersById;*/
    
    
    public RolesViewModel() {
    }
    
    
    public RolesViewModel(int id, String name/*, Collection<Users> usersById*/) {
        this.id = id;
        this.name = name;
        /*this.usersById = usersById;*/
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
    
   /* public Collection<Users> getUsersById() {
        return usersById;
    }
    
    public void setUsersById(Collection<Users> usersById) {
        this.usersById = usersById;
    }*/
}
