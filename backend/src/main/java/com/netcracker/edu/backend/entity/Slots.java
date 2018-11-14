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
public class Slots {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String startTime;
    private String endTime;
    /*@JsonIgnore
    private Set<Timetable> timetablesById;*/
    
    public Slots() {
    }
    
    public Slots(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
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
    @Column(name = "start_time", nullable = false, length = 45)
    public String getStartTime() {
        return startTime;
    }
    
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    @Basic
    @Column(name = "end_time", nullable = false, length = 45)
    public String getEndTime() {
        return endTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    
    
    /*@OneToMany(mappedBy = "slotsBySlotId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
        Slots slots = (Slots) o;
        return id == slots.id &&
                Objects.equals(startTime, slots.startTime) &&
                Objects.equals(endTime, slots.endTime) /*&&
                Objects.equals(timetablesById, slots.timetablesById)*/;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime/*, timetablesById*/);
    }
    
    @Override
    public String toString() {
        return "Slots{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                /*", timetablesById=" + timetablesById +*/
                '}';
    }
}
