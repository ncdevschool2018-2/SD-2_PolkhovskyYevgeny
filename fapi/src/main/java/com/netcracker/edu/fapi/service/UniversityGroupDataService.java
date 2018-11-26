package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.PageGroupViewModel;
import com.netcracker.edu.fapi.models.UniversityGroupViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UniversityGroupDataService {
    List<UniversityGroupViewModel> getAll();
    
    UniversityGroupViewModel getUniversityGroupById(int id);
    
    UniversityGroupViewModel saveUniversityGroup(UniversityGroupViewModel group);
    
    void deleteUniversityGroup(int id);
    
    PageGroupViewModel getPageGroup(int page);
}
