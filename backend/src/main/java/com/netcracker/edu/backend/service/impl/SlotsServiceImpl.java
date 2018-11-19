package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Slots;
import com.netcracker.edu.backend.repository.SlotsRepository;
import com.netcracker.edu.backend.service.SlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SlotsServiceImpl implements SlotsService {
    
    private SlotsRepository repository;
    
    @Autowired
    public SlotsServiceImpl(SlotsRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public Slots saveSlots(Slots slot) {
        return repository.save(slot);
    }
    
    @Override
    public Optional<Slots> getSlotsById(int id) {
        return repository.findById(id);
    }
    
    @Override
    public Iterable<Slots> getAllSlots() {
        return repository.findAll();
    }
    
    @Override
    public void deleteSlots(int id) {
        repository.deleteById(id);
    }
}
