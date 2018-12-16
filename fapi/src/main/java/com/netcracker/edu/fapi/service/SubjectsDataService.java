package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.SubjectsViewModel;

import java.util.List;

public interface SubjectsDataService {
    List<SubjectsViewModel> getAll();
    
    SubjectsViewModel getSubjectsById(int id);
    
    List<SubjectsViewModel> getDistinctSubject();
    
    List<SubjectsViewModel> getSubjectsForTeacher(int id);
    
    List<Integer> getIdChoosenSubject(String subject);
    
    SubjectsViewModel saveSubjects(SubjectsViewModel subject);
    
    void deleteSubjects(int id);
    
    List<SubjectsViewModel> findSubjectsPage(int page);
    
    List<SubjectsViewModel> findSubjects(String word);
    
    Integer getTotalPages();
}
