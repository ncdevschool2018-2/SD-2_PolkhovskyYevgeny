package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UniversityGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UniversityGroupService {
    UniversityGroup saveUniversityGroup(UniversityGroup universityGroup);
    
    Optional<UniversityGroup> getUniversityGroupById(int id);
    
    Iterable<UniversityGroup> getAllUniversityGroup();
    
    List<UniversityGroup> getAllOrderUniversityGroup();
    
    Page<UniversityGroup> findAll(Pageable pageable);
    
    void deleteUniversityGroup(int id);
    
    List<UniversityGroup> findGroupPage(int offset);
    
    List<UniversityGroup> findGroup(String  word);
    
    Integer getTotalPages();
    
}
