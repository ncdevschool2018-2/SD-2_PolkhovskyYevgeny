package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pupils {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    //private Users usersByUserId;
    private int groupId;
    private int userId;
    /*private UniversityGroup universityGroupByGroupId;*/
    
    public Pupils(String name, String surname, Users usersByUserId) {
        this.name = name;
        this.surname = surname;
        //this.usersByUserId = usersByUserId;
    }
    
    public Pupils(String name, String surname, int groupId, int userId) {
        this.name = name;
        this.surname = surname;
        this.groupId = groupId;
        this.userId = userId;
    }
    
    public Pupils() {
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
    
    
    /*@ManyToOne
    
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public Users getUsersByUserId() {
        return usersByUserId;
    }
    
    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }*/
    
    @Basic
    
    @Column(name = "group_id", nullable = false)
    public int getGroupId() {
        return groupId;
    }
    
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    
    @Basic
    
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    /*@ManyToOne
    
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = true)
    public UniversityGroup getUniversityGroupByGroupId() {
        return universityGroupByGroupId;
    }
    
    public void setUniversityGroupByGroupId(UniversityGroup universityGroupByGroupId) {
        this.universityGroupByGroupId = universityGroupByGroupId;
    }
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupils pupils = (Pupils) o;
        return id == pupils.id &&
                groupId == pupils.groupId &&
                userId == pupils.userId &&
                Objects.equals(name, pupils.name) &&
                Objects.equals(surname, pupils.surname) /*&&
                Objects.equals(usersByUserId, pupils.usersByUserId)*/ /*&&
                Objects.equals(universityGroupByGroupId, pupils.universityGroupByGroupId)*/;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, /*usersByUserId,*/ groupId, userId/*, universityGroupByGroupId*/);
    }
    
    @Override
    public String toString() {
        return "Pupils{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                /* ", usersByUserId=" + usersByUserId +*/
                ", groupId=" + groupId +
                ", userId=" + userId +
                /*", universityGroupByGroupId=" + universityGroupByGroupId +*/
                '}';
    }
}
