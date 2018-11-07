package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    //@JsonIgnore
    
    //private Set<Users> usersById;
    
    
    public Roles() {
    }
    
    public Roles(String name) {
        this.name = name;
    }
    
    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    //@OneToMany(mappedBy = "rolesByRoleId" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //public Set<Users> getUsersById() {
    //    return usersById;
    //}
    
    //public void setUsersById(Set<Users> usersById) {
    //    this.usersById = usersById;
    //}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return id == roles.id &&
                Objects.equals(name, roles.name)
                //&&
                //Objects.equals(usersById, roles.usersById)
        ;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name
                //,
                //usersById
        );
    }
    
    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", usersById=" + usersById +
                '}';
    }
}
