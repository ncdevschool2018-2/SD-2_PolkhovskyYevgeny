package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "days_of_week", schema = "control")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DaysOfWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    /*@JsonIgnore
    private Set<Timetable> timetablesById;*/
    
    public DaysOfWeek() {
    }
    
    public DaysOfWeek(String name) {
        this.name = name;
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
    
    
    /*@OneToMany(mappedBy = "daysOfWeekByDayOfWeekId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
        DaysOfWeek that = (DaysOfWeek) o;
        return id == that.id &&
                Objects.equals(name, that.name) /*&&
                Objects.equals(timetablesById, that.timetablesById)*/;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name/*, timetablesById*/);
    }
    
    @Override
    public String toString() {
        return "DaysOfWeek{" +
                "id=" + id +
                ", name='" + name + '\'' +
                /*", timetablesById=" + timetablesById +*/
                '}';
    }
}
