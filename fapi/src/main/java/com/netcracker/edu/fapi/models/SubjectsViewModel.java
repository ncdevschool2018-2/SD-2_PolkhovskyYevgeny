package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectsViewModel {
    private int id;
    private String subject;
//    private Teacher teacherByTeacherId;

//    private Collection<Timetable> timetablesById;
    
    
    public SubjectsViewModel() {
    }
    
    
    public SubjectsViewModel(int id, String subject) {
        this.id = id;
        this.subject = subject;
        
    }
    
    
    public SubjectsViewModel(String subject) {
        this.subject = subject;
        
    }
    
    
    public int getId() {
        return id;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getSubject() {
        return subject;
    }
    
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
}
