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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private String subject;
    private Users usersByUserId;
    private int userId;
    /*@JsonIgnore
    private Set<Subjects> subjectsById;*/
    
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
    
    @Basic
    @Column(name = "surname", nullable = false, length = 45)
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    @Basic
    @Column(name = "subject", nullable = false, length = 45)
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public Users getUsersByUserId() {
        return usersByUserId;
    }
    
    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
    
    @Basic
    @Column(name = "user_id", nullable = false,insertable=false,updatable =false)
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    /*@OneToMany(mappedBy = "teacherByTeacherId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Subjects> getSubjectsById() {
        return subjectsById;
    }
    
    public void setSubjectsById(Set<Subjects> subjectsById) {
        this.subjectsById = subjectsById;
    }
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                userId == teacher.userId &&
                Objects.equals(name, teacher.name) &&
                Objects.equals(surname, teacher.surname) &&
                Objects.equals(subject, teacher.subject) &&
                Objects.equals(usersByUserId, teacher.usersByUserId) /*&&
                Objects.equals(subjectsById, teacher.subjectsById)*/;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, subject, usersByUserId, userId/*, subjectsById*/);
    }
    
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subject='" + subject + '\'' +
                ", usersByUserId=" + usersByUserId +
                ", userId=" + userId +
                /*", subjectsById=" + subjectsById +*/
                '}';
    }
}
