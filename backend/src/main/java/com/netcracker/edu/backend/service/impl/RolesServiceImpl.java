package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Roles;
import com.netcracker.edu.backend.repository.RolesRepository;
import com.netcracker.edu.backend.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RolesServiceImpl implements RolesService {
    
    private RolesRepository repository;
    
    @Autowired
    public RolesServiceImpl(RolesRepository repository){
        this.repository=repository;
    }
    
    @Override
    public Roles saveRoles(Roles role) {
        return repository.save(role);
    }
    
    @Override
    public Optional<Roles> getRolesById(int id) {
        return repository.findById(id);
    }
    
    @Override
    public Iterable<Roles> getAllRoles() {
        return repository.findAll();
    }
    
    @Override
    public void deleteRoles(int id) {
        repository.deleteById(id);
    }
}
