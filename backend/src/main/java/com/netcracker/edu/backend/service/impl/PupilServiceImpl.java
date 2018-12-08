package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.backend.repository.PupilsRepository;
import com.netcracker.edu.backend.service.PupilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PupilServiceImpl implements PupilsService {
    
    private PupilsRepository repository;
    
    
    @Autowired
    public PupilServiceImpl(PupilsRepository repository) {
        this.repository = repository;
    }
    
    
    @Override
    public Pupils savePupil(Pupils pupil) {
        return repository.save(pupil);
    }
    
    
    @Override
    public Optional<Pupils> getPupilById(int id) {
        return repository.findById(id);
    }
    
    
    @Override
    public Iterable<Pupils> getAllPupils() {
        return repository.findAll();
    }
    
    
    @Override
    public List<Pupils> getByGroupIdOrderBySurname(int id) {
        return repository.findByGroupIdOrderBySurname(id);
    }
    
    
    @Override
    public List<Pupils> findPupilBySurnameAndName(String surname, String name, int groupId) {
        return repository.findPupilBySurnameAndName(surname, name, groupId);
    }
    
    
    @Override
    public List<Pupils> findPupilBySurname(String surname, int groupId) {
        return repository.findPupilBySurname(surname, groupId);
    }
    
    
    @Override
    public List<Pupils> findPupilByName(String name, int groupId) {
        return repository.findPupilByName(name, groupId);
    }
    
    
    @Override
    public void deletePupil(int id) {
        repository.deleteById(id);
    }
    
    
    @Override
    public Pupils findByUserId(int userId) {
        return repository.findByUserId(userId);
    }
}
