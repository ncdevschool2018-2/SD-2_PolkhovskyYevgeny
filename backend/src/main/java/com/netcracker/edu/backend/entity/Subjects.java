package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String subject;
    private Teacher teacherByTeacherId;
    private int teacherId;
    /*@JsonIgnore
    private Set<Timetable> timetablesById;*/
    
    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "subject", nullable = false, length = 45)
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
    
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    public Teacher getTeacherByTeacherId() {
        return teacherByTeacherId;
    }
    
    public void setTeacherByTeacherId(Teacher teacherByTeacherId) {
        this.teacherByTeacherId = teacherByTeacherId;
    }
    
    @Basic
    @Column(name = "teacher_id", nullable = false,insertable=false,updatable =false)
    public int getTeacherId() {
        return teacherId;
    }
    
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    
//    @OneToMany(mappedBy = "subjectsBySubjectId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    public Set<Timetable> getTimetablesById() {
//        return timetablesById;
//    }
//
//    public void setTimetablesById(Set<Timetable> timetablesById) {
//        this.timetablesById = timetablesById;
//    }
//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subjects subjects = (Subjects) o;
        return id == subjects.id &&
                teacherId == subjects.teacherId &&
                Objects.equals(subject, subjects.subject) &&
                Objects.equals(teacherByTeacherId, subjects.teacherByTeacherId) /*&&
                Objects.equals(timetablesById, subjects.timetablesById)*/;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, subject, teacherByTeacherId, teacherId/*, timetablesById*/);
    }
    
    @Override
    public String toString() {
        return "Subjects{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", teacherByTeacherId=" + teacherByTeacherId +
                ", teacherId=" + teacherId +
                /*", timetablesById=" + timetablesById +*/
                '}';
    }
}