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
    private Subjects subjectsBySubjectId;
    private Slots slotsBySlotId;
    private DaysOfWeek daysOfWeekByDayOfWeekId;
    private int groupId;
    private int subjectId;
    private int slotId;
    private int dayOfWeekId;
    private UniversityGroup universityGroupByGroupId;
    
    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    
    
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false)
    public Subjects getSubjectsBySubjectId() {
        return subjectsBySubjectId;
    }
    
    public void setSubjectsBySubjectId(Subjects subjectsBySubjectId) {
        this.subjectsBySubjectId = subjectsBySubjectId;
    }
    
    @ManyToOne
    @JoinColumn(name = "slot_id", referencedColumnName = "id", nullable = false)
    public Slots getSlotsBySlotId() {
        return slotsBySlotId;
    }
    
    public void setSlotsBySlotId(Slots slotsBySlotId) {
        this.slotsBySlotId = slotsBySlotId;
    }
    
    @ManyToOne
    @JoinColumn(name = "day_of_week_id", referencedColumnName = "id", nullable = false)
    public DaysOfWeek getDaysOfWeekByDayOfWeekId() {
        return daysOfWeekByDayOfWeekId;
    }
    
    public void setDaysOfWeekByDayOfWeekId(DaysOfWeek daysOfWeekByDayOfWeekId) {
        this.daysOfWeekByDayOfWeekId = daysOfWeekByDayOfWeekId;
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
    
    
    
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    public UniversityGroup getUniversityGroupByGroupId() {
        return universityGroupByGroupId;
    }
    
    public void setUniversityGroupByGroupId(UniversityGroup universityGroupByGroupId) {
        this.universityGroupByGroupId = universityGroupByGroupId;
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
                dayOfWeekId == timetable.dayOfWeekId &&
                Objects.equals(subjectsBySubjectId, timetable.subjectsBySubjectId) &&
                Objects.equals(slotsBySlotId, timetable.slotsBySlotId) &&
                Objects.equals(daysOfWeekByDayOfWeekId, timetable.daysOfWeekByDayOfWeekId) &&
                Objects.equals(universityGroupByGroupId, timetable.universityGroupByGroupId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, subjectsBySubjectId, slotsBySlotId, daysOfWeekByDayOfWeekId, groupId, subjectId, slotId, dayOfWeekId, universityGroupByGroupId);
    }
    
    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", subjectsBySubjectId=" + subjectsBySubjectId +
                ", slotsBySlotId=" + slotsBySlotId +
                ", daysOfWeekByDayOfWeekId=" + daysOfWeekByDayOfWeekId +
                ", groupId=" + groupId +
                ", subjectId=" + subjectId +
                ", slotId=" + slotId +
                ", dayOfWeekId=" + dayOfWeekId +
                ", universityGroupByGroupId=" + universityGroupByGroupId +
                '}';
    }
}
