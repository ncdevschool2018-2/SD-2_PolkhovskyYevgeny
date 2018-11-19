package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.NewUserViewModel;
import com.netcracker.edu.fapi.models.TeacherViewModel;

import java.util.List;

public interface TeacherDataService {
    List<TeacherViewModel> getAll();
    
    TeacherViewModel getTeacherById(int id);
    
    List<TeacherViewModel> getTeachersSbj(int subject);
    
    TeacherViewModel saveTeacher(NewUserViewModel teacher);
    
    void deleteTeacher(int id);
}
