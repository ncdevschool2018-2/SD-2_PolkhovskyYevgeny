package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.backend.entity.Timetable;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SlotsViewModel {
    private int id;
    private String startTime;
    private String endTime;
    private Collection<Timetable> timetablesById;
    
    public SlotsViewModel() {
    }
    
    public SlotsViewModel(int id, String startTime, String endTime, Collection<Timetable> timetablesById) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timetablesById = timetablesById;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getStartTime() {
        return startTime;
    }
    
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    public String getEndTime() {
        return endTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public Collection<Timetable> getTimetablesById() {
        return timetablesById;
    }
    
    public void setTimetablesById(Collection<Timetable> timetablesById) {
        this.timetablesById = timetablesById;
    }
}
