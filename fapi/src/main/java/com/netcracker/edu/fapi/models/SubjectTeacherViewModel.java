package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectTeacherViewModel {
    private int id;
    private int subjectId;
    private int teacherId;
    
    
    public SubjectTeacherViewModel() {
    }
    
    
    public SubjectTeacherViewModel(int id, int subjectId, int teacherId) {
        this.id = id;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }
    
    
    public SubjectTeacherViewModel(int subjectId, int teacherId) {
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }
    
    
    public int getId() {
        return id;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }
    
    
    public int getSubjectId() {
        return subjectId;
    }
    
    
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    
    
    public int getTeacherId() {
        return teacherId;
    }
    
    
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
