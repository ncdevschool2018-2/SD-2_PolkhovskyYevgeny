package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.SubjectTeacherViewModel;

import java.util.List;

public interface SubjectTeacherDataService {
    List<SubjectTeacherViewModel> getAll();
    
    SubjectTeacherViewModel getSSubjectTeacherById(int id);
    
    SubjectTeacherViewModel saveSubjectTeacher(SubjectTeacherViewModel slot);
    
    void deleteSubjectTeacher(int id);
}
