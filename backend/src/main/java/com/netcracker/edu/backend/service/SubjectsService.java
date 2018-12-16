package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Subjects;

import java.util.List;
import java.util.Optional;

public interface SubjectsService {
    Subjects saveSubjects(Subjects subject);
    
    Optional<Subjects> getSubjectsById(int id);
    
    Iterable<Subjects> getAllSubjects();
    
    List<Subjects> getSubjectsForTeacher(int teacherId);
    
    List<Subjects> getDistinctSubject();
    
    List<Subjects> getAllBySubject(String subject);
    
    List<Subjects> findGSubjectsPage(int offset);
    
    Integer getTotalPages();
    
    List<Subjects> findSubjects(String word);
    
    //Integer[] getIdChoosenSubject(String subject);
    void deleteSubjects(int id);
}
