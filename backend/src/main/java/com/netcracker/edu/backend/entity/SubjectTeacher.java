package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "subject_teacher", schema = "control")
public class SubjectTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int subjectId;
    private int teacherId;
    
    public SubjectTeacher() {
    }
    
    public SubjectTeacher(int id, int subjectId, int teacherId) {
        this.id = id;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }
    
    public SubjectTeacher(int subjectId, int teacherId) {
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }
    
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "subject_id", nullable = false)
    public int getSubjectId() {
        return subjectId;
    }
    
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    
    @Basic
    @Column(name = "teacher_id", nullable = false)
    public int getTeacherId() {
        return teacherId;
    }
    
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        SubjectTeacher that = (SubjectTeacher) o;
        
        if (id != that.id) return false;
        if (subjectId != that.subjectId) return false;
        if (teacherId != that.teacherId) return false;
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + subjectId;
        result = 31 * result + teacherId;
        return result;
    }
}
