package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int groupId;
    private int subjectId;
    private int slotId;
    private int dayOfWeekId;
    
    
    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    
    
    
    @Basic
    @Column(name = "group_id", nullable = false,insertable=false,updatable =false)
    public int getGroupId() {
        return groupId;
    }
    
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    
    @Basic
    @Column(name = "subject_id", nullable = false,insertable=false,updatable =false)
    public int getSubjectId() {
        return subjectId;
    }
    
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    
    @Basic
    @Column(name = "slot_id", nullable = false,insertable=false,updatable =false)
    public int getSlotId() {
        return slotId;
    }
    
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
    
    @Basic
    @Column(name = "day_of_week_id", nullable = false,insertable=false,updatable =false)
    public int getDayOfWeekId() {
        return dayOfWeekId;
    }
    
    public void setDayOfWeekId(int dayOfWeekId) {
        this.dayOfWeekId = dayOfWeekId;
    }
    
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return id == timetable.id &&
                groupId == timetable.groupId &&
                subjectId == timetable.subjectId &&
                slotId == timetable.slotId &&
                dayOfWeekId == timetable.dayOfWeekId;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id,  groupId, subjectId, slotId, dayOfWeekId);
    }
    
    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", subjectId=" + subjectId +
                ", slotId=" + slotId +
                ", dayOfWeekId=" + dayOfWeekId +
                
                '}';
    }
}
