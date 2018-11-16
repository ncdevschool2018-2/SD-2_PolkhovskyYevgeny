package com.netcracker.edu.fapi.models;

public class TimetableExampleViewModel {

    private String subject;
    private String teacherName;
    private String teacherSurname;
    private int teacherId;
     private String time;
     private String day;
     private String group;
     private int timetableId;
    
    public TimetableExampleViewModel() {
    }
    
    public TimetableExampleViewModel(String subject, String teacherName, String teacherSurname, int teacherId, String time, String day, String group, int timetableId) {
        this.subject = subject;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherId = teacherId;
        this.time = time;
        this.day = day;
        this.group = group;
        this.timetableId = timetableId;
    }
    
    public int getTimetableId() {
        return timetableId;
    }
    
    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }
    
    public int getTeacherId() {
        return teacherId;
    }
    
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getTeacherName() {
        return teacherName;
    }
    
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    
    public String getTeacherSurname() {
        return teacherSurname;
    }
    
    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public String getDay() {
        return day;
    }
    
    public void setDay(String day) {
        this.day = day;
    }
    
    public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
}
