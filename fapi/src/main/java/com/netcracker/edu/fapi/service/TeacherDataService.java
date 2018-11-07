package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.NewUserViewModel;
import com.netcracker.edu.fapi.models.TeacherViewModel;

import java.util.List;

public interface TeacherDataService {
    List<TeacherViewModel> getAll();
    TeacherViewModel getTeacherById(Long id);
    TeacherViewModel saveTeacher(NewUserViewModel teacher);
    void deleteTeacher(Long id);
}
