package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.backend.entity.UniversityGroup;

import java.util.Collection;
import java.util.Optional;

public interface UniversityGroupService {
    UniversityGroup saveUniversityGroup(UniversityGroup universityGroup);
    Optional<UniversityGroup> getUniversityGroupById(Long id);
    Iterable<UniversityGroup> getAllUniversityGroup();
    void deleteUniversityGroup(Long id);
    
}
