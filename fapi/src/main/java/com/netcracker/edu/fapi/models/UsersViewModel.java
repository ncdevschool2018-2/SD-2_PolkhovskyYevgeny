package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.backend.entity.Roles;
import com.netcracker.edu.backend.entity.Teacher;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersViewModel {
    private int id;
    private String login;
    private String password;
    private Roles rolesByRoleId;
    private int roleId;
    private Collection<Pupils> pupilsById;
    private Collection<Teacher> teachersById;
    
    public UsersViewModel() {
    }
    
    public UsersViewModel(int id, String login, String password, Roles rolesByRoleId, int roleId, Collection<Pupils> pupilsById, Collection<Teacher> teachersById) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.rolesByRoleId = rolesByRoleId;
        this.roleId = roleId;
        this.pupilsById = pupilsById;
        this.teachersById = teachersById;
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
    
    public Roles getRolesByRoleId() {
        return rolesByRoleId;
    }
    
    public void setRolesByRoleId(Roles rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }
    
    public int getRoleId() {
        return roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    public Collection<Pupils> getPupilsById() {
        return pupilsById;
    }
    
    public void setPupilsById(Collection<Pupils> pupilsById) {
        this.pupilsById = pupilsById;
    }
    
    public Collection<Teacher> getTeachersById() {
        return teachersById;
    }
    
    public void setTeachersById(Collection<Teacher> teachersById) {
        this.teachersById = teachersById;
    }
}
