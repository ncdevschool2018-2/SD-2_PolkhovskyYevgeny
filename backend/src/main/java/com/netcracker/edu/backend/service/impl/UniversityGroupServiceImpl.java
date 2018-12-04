package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.UniversityGroup;
import com.netcracker.edu.backend.repository.UniversityGroupRepository;
import com.netcracker.edu.backend.service.UniversityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.lang.Math.toIntExact;

@Component
public class UniversityGroupServiceImpl implements UniversityGroupService {
    
    private UniversityGroupRepository repository;
    
    
    @Autowired
    public UniversityGroupServiceImpl(UniversityGroupRepository repository) {
        this.repository = repository;
    }
    
    
    @Override
    public UniversityGroup saveUniversityGroup(UniversityGroup universityGroup) {
        return repository.save(universityGroup);
    }
    
    
    @Override
    public Optional<UniversityGroup> getUniversityGroupById(int id) {
        return repository.findById(id);
    }
    
    
    @Override
    public Iterable<UniversityGroup> getAllUniversityGroup() {
        return repository.findAll();
    }
    
    
    @Override
    public List<UniversityGroup> getAllOrderUniversityGroup() {
        return repository.findAllOrderByName();
    }
    
    
    @Override
    public Page<UniversityGroup> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    
    
    @Override
    public void deleteUniversityGroup(int id) {
        repository.deleteById(id);
    }
    
    
    @Override
    public List<UniversityGroup> findGroupPage(int offset) {
        return repository.findGroupPage(offset);
    }
    
    
    @Override
    public List<UniversityGroup> findGroup(String word) {
        //word='%'+word+'%';
        return repository.findGroup(word);
    }
    
    
    @Override
    public Integer getTotalPages() {
        return toIntExact(repository.count());
    }
    
    
}
