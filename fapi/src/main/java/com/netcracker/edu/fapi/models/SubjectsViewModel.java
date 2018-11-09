package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.backend.entity.Teacher;
import com.netcracker.edu.backend.entity.Timetable;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectsViewModel {
    private int id;
    private String subject;
//    private Teacher teacherByTeacherId;
    private int teacherId;
//    private Collection<Timetable> timetablesById;
    
    public SubjectsViewModel() {
    }
    
    public SubjectsViewModel(int id, String subject, /*Teacher teacherByTeacherId,*/ int teacherId/*, Collection<Timetable> timetablesById*/) {
        this.id = id;
        this.subject = subject;
//        this.teacherByTeacherId = teacherByTeacherId;
        this.teacherId = teacherId;
        /*this.timetablesById = timetablesById;*/
    }
    
    public SubjectsViewModel(String subject, int teacherId) {
        this.subject = subject;
        this.teacherId = teacherId;
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
    
//    public Teacher getTeacherByTeacherId() {
//        return teacherByTeacherId;
//    }
//
//    public void setTeacherByTeacherId(Teacher teacherByTeacherId) {
//        this.teacherByTeacherId = teacherByTeacherId;
//    }
    
    public int getTeacherId() {
        return teacherId;
    }
    
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    
    /*public Collection<Timetable> getTimetablesById() {
        return timetablesById;
    }
    
    public void setTimetablesById(Collection<Timetable> timetablesById) {
        this.timetablesById = timetablesById;
    }*/
}
