package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.backend.entity.Timetable;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DaysOfWeekViewModel {
    private int id;
    private String name;
    private Collection<Timetable> timetablesById;
    
    public DaysOfWeekViewModel() {
    }
    
    public DaysOfWeekViewModel(int id, String name, Collection<Timetable> timetablesById) {
        this.id = id;
        this.name = name;
        this.timetablesById = timetablesById;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Collection<Timetable> getTimetablesById() {
        return timetablesById;
    }
    
    public void setTimetablesById(Collection<Timetable> timetablesById) {
        this.timetablesById = timetablesById;
    }
}
