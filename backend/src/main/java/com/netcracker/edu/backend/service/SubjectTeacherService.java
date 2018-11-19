package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.SubjectTeacher;

import java.util.Optional;

public interface SubjectTeacherService {
    SubjectTeacher saveSubjectTeacher(SubjectTeacher subjectTeacher);
    
    Optional<SubjectTeacher> getSubjectTeacherById(int id);
    
    Iterable<SubjectTeacher> getAllSubjectTeacher();
    
    Integer[] getIdChoosenSubject(int subject);
    
    void deleteSubjectTeacher(int id);
}
