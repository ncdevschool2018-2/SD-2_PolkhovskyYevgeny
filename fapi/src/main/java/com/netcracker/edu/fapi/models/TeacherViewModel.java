package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherViewModel {
    private int id;
    private String name;
    private String surname;
    
    
    private int userId;
    /*private Collection<Subjects> subjectsById;*/
    
    public TeacherViewModel() {
    }
    
    public TeacherViewModel(int id, String name, String surname, int userId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.userId = userId;
    }
    
    public TeacherViewModel(String name, String surname, int userId) {
        this.name = name;
        this.surname = surname;
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
    
    
    /*public Users getUsersByUserId() {
        return usersByUserId;
    }
    
    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
    */
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    /*public Collection<Subjects> getSubjectsById() {
        return subjectsById;
    }
    
    public void setSubjectsById(Collection<Subjects> subjectsById) {
        this.subjectsById = subjectsById;
    }*/
}
