package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupViewModel {
    private long id;
    private String group;
    
    public GroupViewModel() {
    }
    
    public GroupViewModel(long id, String group) {
        this.id = id;
        this.group = group;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
}
