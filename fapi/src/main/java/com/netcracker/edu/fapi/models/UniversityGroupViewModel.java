package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UniversityGroupViewModel {
    private int id;
    private String name;
    /*private Collection<Pupils> pupilsById;
    private Collection<Timetable> timetablesById;*/
    
    public UniversityGroupViewModel() {
    }
    
    public UniversityGroupViewModel(int id, String name/*, Collection<Pupils> pupilsById, Collection<Timetable> timetablesById*/) {
        this.id = id;
        this.name = name;
        /*this.pupilsById = pupilsById;
        this.timetablesById = timetablesById;*/
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
    
    /*public Collection<Pupils> getPupilsById() {
        return pupilsById;
    }
    
    public void setPupilsById(Collection<Pupils> pupilsById) {
        this.pupilsById = pupilsById;
    }
    
    public Collection<Timetable> getTimetablesById() {
        return timetablesById;
    }
    
    public void setTimetablesById(Collection<Timetable> timetablesById) {
        this.timetablesById = timetablesById;
    }*/
}
