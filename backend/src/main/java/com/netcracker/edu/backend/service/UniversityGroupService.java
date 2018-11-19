package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UniversityGroup;

import java.util.Optional;

public interface UniversityGroupService {
    UniversityGroup saveUniversityGroup(UniversityGroup universityGroup);
    
    Optional<UniversityGroup> getUniversityGroupById(int id);
    
    Iterable<UniversityGroup> getAllUniversityGroup();
    
    void deleteUniversityGroup(int id);
    
}
