package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    //private Roles rolesByRoleId;
    private int roleId;
    /*@JsonIgnore
    private Set<Pupils> pupilsById;
    @JsonIgnore
    private Set<Teacher> teachersById;*/
    
    public Users() {
    }
    
    public Users(String login, String password, int roleId) {
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }
    
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "login", nullable = false, length = 45,unique = true)
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    /*@ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public Roles getRolesByRoleId() {
        return rolesByRoleId;
    }
    
    public void setRolesByRoleId(Roles rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }
    */
    @Basic
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    /*@OneToMany(mappedBy = "usersByUserId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    
    public Set<Pupils> getPupilsById() {
        return pupilsById;
    }
    
    public void setPupilsById(Set<Pupils> pupilsById) {
        this.pupilsById = pupilsById;
    }
    
    @OneToMany(mappedBy = "usersByUserId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Teacher> getTeachersById() {
        return teachersById;
    }
    
    public void setTeachersById(Set<Teacher> teachersById) {
        this.teachersById = teachersById;
    }
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                roleId == users.roleId &&
                Objects.equals(login, users.login) &&
                Objects.equals(password, users.password) /*&&
                Objects.equals(rolesByRoleId, users.rolesByRoleId)*/ /*&&
                Objects.equals(pupilsById, users.pupilsById) &&
                Objects.equals(teachersById, users.teachersById)*/;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, /*rolesByRoleId,*/ roleId/*, pupilsById, teachersById*/);
    }
    
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                /*", rolesByRoleId=" + rolesByRoleId +*/
                ", roleId=" + roleId +
                /*", pupilsById=" + pupilsById +
                ", teachersById=" + teachersById +*/
                '}';
    }
}
