package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.DaysOfWeek;
import com.netcracker.edu.backend.repository.DaysOfWeekRepository;
import com.netcracker.edu.backend.service.DaysOfWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class DaysOfWeekServiceImpl implements DaysOfWeekService {
    
    private DaysOfWeekRepository repository;
    
    @Autowired
    public DaysOfWeekServiceImpl(DaysOfWeekRepository repository){
        this.repository=repository;
    }
    @Override
    public DaysOfWeek saveDaysOfWeek(DaysOfWeek day) {
        return repository.save(day);
    }
    
    @Override
    public Optional<DaysOfWeek> getDaysOfWeekById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public Iterable<DaysOfWeek> getAllDaysOfWeek() {
        return repository.findAll();
    }
    
    @Override
    public void deleteDaysOfWeek(Long id) {
        repository.deleteById(id);
    }
}
