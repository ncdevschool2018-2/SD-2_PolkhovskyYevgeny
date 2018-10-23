package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Group;
import com.netcracker.edu.backend.repository.GroupRepository;
import com.netcracker.edu.backend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GroupServiceImpl implements GroupService {
    private GroupRepository repository;
    
    @Autowired
    public GroupServiceImpl(GroupRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public Group saveGroup(Group group) {
        return repository.save(group);
    }
    
    @Override
    public Optional<Group> getGroupById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public Iterable<Group> getAllGroups() {
        return repository.findAll();
    }
    
    @Override
    public void deleteGroup(Long id) {
        repository.deleteById(id);
    }
    
    
}
