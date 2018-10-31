package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.SubjectsViewModel;

import java.util.List;

public interface SubjectsDataService {
    List<SubjectsViewModel> getAll();
    SubjectsViewModel getSubjectsById(Long id);
    SubjectsViewModel saveSubjects(SubjectsViewModel subject);
    void deleteSubjects(Long id);
}
