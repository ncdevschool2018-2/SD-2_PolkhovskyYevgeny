package com.netcracker.edu.backend.dto;

public class TeacherDto {
    
    private String name;
    private String surname;
    private int subjectId;
    
    private int userId;
    private String login;
    private String password;
    private int roleId;
    
    
    public TeacherDto() {
    }
    
    
    public TeacherDto(String name, String surname, int subjectId, int userId, String login, String password, int roleId) {
        this.name = name;
        this.surname = surname;
        this.subjectId = subjectId;
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
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
    
    
    public int getSubjectId() {
        return subjectId;
    }
    
    
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
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
