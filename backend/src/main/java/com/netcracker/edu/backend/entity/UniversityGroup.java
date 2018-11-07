package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "university_group", schema = "control")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniversityGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    /*@JsonIgnore
    private Set<Pupils> pupilsById;
    @JsonIgnore
    private Set<Timetable> timetablesById;*/
    
    public UniversityGroup() {
    }
    
    public UniversityGroup(String name) {
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
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    
   /* @OneToMany(mappedBy = "universityGroupByGroupId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   
    public Set<Pupils> getPupilsById() {
        return pupilsById;
    }
    
    public void setPupilsById(Set<Pupils> pupilsById) {
        this.pupilsById = pupilsById;
    }
    
    @OneToMany(mappedBy = "universityGroupByGroupId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Timetable> getTimetablesById() {
        return timetablesById;
    }
    
    public void setTimetablesById(Set<Timetable> timetablesById) {
        this.timetablesById = timetablesById;
    }
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversityGroup that = (UniversityGroup) o;
        return id == that.id &&
                Objects.equals(name, that.name) /*&&
                Objects.equals(pupilsById, that.pupilsById) &&
                Objects.equals(timetablesById, that.timetablesById)*/;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name/*, pupilsById, timetablesById*/);
    }
    
    @Override
    public String toString() {
        return "UniversityGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                /*", pupilsById=" + pupilsById +
                ", timetablesById=" + timetablesById +*/
                '}';
    }
}
