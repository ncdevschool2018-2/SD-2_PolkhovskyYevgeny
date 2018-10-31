package com.netcracker.edu.fapi.service;

import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.backend.entity.UniversityGroup;
import com.netcracker.edu.fapi.models.UniversityGroupViewModel;

import java.util.Collection;
import java.util.List;

public interface UniversityGroupDataService {
    List<UniversityGroupViewModel> getAll();
    UniversityGroupViewModel getUniversityGroupById(Long id);
    UniversityGroupViewModel saveUniversityGroup(UniversityGroupViewModel group);
    void deleteUniversityGroup(Long id);
    
}
