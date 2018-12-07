package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Pupils;

import java.util.List;
import java.util.Optional;

public interface PupilsService {
    Pupils savePupil(Pupils pupil);
    
    Optional<Pupils> getPupilById(int id);
    
    Iterable<Pupils> getAllPupils();
    
    List<Pupils> getByGroupIdOrderBySurname(int id);
    
    List<Pupils> findPupilBySurnameAndName( String surname,String name,int groupId  );
    
    void deletePupil(int id);
    
    Pupils findByUserId(int userId);
}
