package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "timetable")
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long group_id;
    private long subject_id;
    private long slot_id;
    private long day_of_week_id;
    
    public Timetable() {
    }
    
    public Timetable(long group_id, long subject_id, long slot_id, long day_of_week_id) {
        this.group_id = group_id;
        this.subject_id = subject_id;
        this.slot_id = slot_id;
        this.day_of_week_id = day_of_week_id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getGroup_id() {
        return group_id;
    }
    
    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }
    
    public long getSubject_id() {
        return subject_id;
    }
    
    public void setSubject_id(long subject_id) {
        this.subject_id = subject_id;
    }
    
    public long getSlot_id() {
        return slot_id;
    }
    
    public void setSlot_id(long slot_id) {
        this.slot_id = slot_id;
    }
    
    public long getDay_of_week_id() {
        return day_of_week_id;
    }
    
    public void setDay_of_week_id(long day_of_week_id) {
        this.day_of_week_id = day_of_week_id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return id == timetable.id &&
                Objects.equals(group_id , timetable.group_id) &&
                Objects.equals(subject_id , timetable.subject_id) &&
                Objects.equals(slot_id , timetable.slot_id) &&
                Objects.equals(day_of_week_id , timetable.day_of_week_id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, group_id, subject_id, slot_id, day_of_week_id);
    }
    
    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", group_id=" + group_id +
                ", subject_id=" + subject_id +
                ", slot_id=" + slot_id +
                ", day_of_week_id=" + day_of_week_id +
                '}';
    }
    
}
