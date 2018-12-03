package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private int userId;
    
    
    public Teacher() {
    }
    
    
    public Teacher(String name, String surname, int userId) {
        this.name = name;
        this.surname = surname;
        this.userId = userId;
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
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    @Basic
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }
    
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }
    
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                userId == teacher.userId &&
                Objects.equals(name, teacher.name) &&
                Objects.equals(surname, teacher.surname);
    }
    
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, userId/*, subjectsById*/);
    }
    
    
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                
                ", userId=" + userId +
                
                '}';
    }
}
