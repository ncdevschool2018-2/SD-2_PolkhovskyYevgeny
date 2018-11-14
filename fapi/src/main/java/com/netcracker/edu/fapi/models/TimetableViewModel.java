package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.backend.entity.DaysOfWeek;
import com.netcracker.edu.backend.entity.Slots;
import com.netcracker.edu.backend.entity.Subjects;
import com.netcracker.edu.backend.entity.UniversityGroup;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimetableViewModel {
    private int id;
//    private Subjects subjectsBySubjectId;
//    private Slots slotsBySlotId;
//    private DaysOfWeek daysOfWeekByDayOfWeekId;
    private int groupId;
    private int subjectId;
    private int slotId;
    private int dayOfWeekId;
    /*private UniversityGroup universityGroupByGroupId;*/
    
    public TimetableViewModel() {
    }
    
    public TimetableViewModel(int id, /*Subjects subjectsBySubjectId, Slots slotsBySlotId, DaysOfWeek daysOfWeekByDayOfWeekId,*/ int groupId, int subjectId, int slotId, int dayOfWeekId/*, UniversityGroup universityGroupByGroupId*/) {
        this.id = id;
        /*this.subjectsBySubjectId = subjectsBySubjectId;
        this.slotsBySlotId = slotsBySlotId;
        this.daysOfWeekByDayOfWeekId = daysOfWeekByDayOfWeekId;*/
        this.groupId = groupId;
        this.subjectId = subjectId;
        this.slotId = slotId;
        this.dayOfWeekId = dayOfWeekId;
        /*this.universityGroupByGroupId = universityGroupByGroupId;*/
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    /*public Subjects getSubjectsBySubjectId() {
        return subjectsBySubjectId;
    }
    
    public void setSubjectsBySubjectId(Subjects subjectsBySubjectId) {
        this.subjectsBySubjectId = subjectsBySubjectId;
    }
    
    public Slots getSlotsBySlotId() {
        return slotsBySlotId;
    }
    
    public void setSlotsBySlotId(Slots slotsBySlotId) {
        this.slotsBySlotId = slotsBySlotId;
    }
    
    public DaysOfWeek getDaysOfWeekByDayOfWeekId() {
        return daysOfWeekByDayOfWeekId;
    }
    
    public void setDaysOfWeekByDayOfWeekId(DaysOfWeek daysOfWeekByDayOfWeekId) {
        this.daysOfWeekByDayOfWeekId = daysOfWeekByDayOfWeekId;
    }*/
    
    public int getGroupId() {
        return groupId;
    }
    
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    
    public int getSubjectId() {
        return subjectId;
    }
    
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    
    public int getSlotId() {
        return slotId;
    }
    
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
    
    public int getDayOfWeekId() {
        return dayOfWeekId;
    }
    
    public void setDayOfWeekId(int dayOfWeekId) {
        this.dayOfWeekId = dayOfWeekId;
    }
    
    /*public UniversityGroup getUniversityGroupByGroupId() {
        return universityGroupByGroupId;
    }
    
    public void setUniversityGroupByGroupId(UniversityGroup universityGroupByGroupId) {
        this.universityGroupByGroupId = universityGroupByGroupId;
    }*/
}
