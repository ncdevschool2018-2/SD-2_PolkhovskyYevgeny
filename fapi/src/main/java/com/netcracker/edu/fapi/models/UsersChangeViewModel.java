package com.netcracker.edu.fapi.models;

public class UsersChangeViewModel {
    private int id;
    private String login;
    private String passwordOld;
    private String passwordNew;
    
    private int roleId;
    
    
    public UsersChangeViewModel() {
    }
    
    
    public UsersChangeViewModel(String login, String passwordOld, String passwordNew, int roleId) {
        this.login = login;
        this.passwordOld = passwordOld;
        this.passwordNew = passwordNew;
        this.roleId = roleId;
    }
    
    
    public UsersChangeViewModel(int id, String login, String passwordOld, String passwordNew, int roleId) {
        this.id = id;
        this.login = login;
        this.passwordOld = passwordOld;
        this.passwordNew = passwordNew;
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
    
    
    public String getPasswordOld() {
        return passwordOld;
    }
    
    
    public void setPasswordOld(String passwordOld) {
        this.passwordOld = passwordOld;
    }
    
    
    public String getPasswordNew() {
        return passwordNew;
    }
    
    
    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }
    
    
    public int getRoleId() {
        return roleId;
    }
    
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
