package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private int id;
    private String subject;
    
    
    public Subjects() {
    }
    
    
    public Subjects(String subject) {
        this.subject = subject;
        
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
    @Column(name = "subject", nullable = false, length = 45)
    public String getSubject() {
        return subject;
    }
    
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subjects subjects = (Subjects) o;
        return id == subjects.id &&
                
                Objects.equals(subject, subjects.subject);
    }
    
    
    @Override
    public int hashCode() {
        return Objects.hash(id, subject);
    }
    
    
    @Override
    public String toString() {
        return "Subjects{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                
                ", teacherId=" +
                
                '}';
    }
}
