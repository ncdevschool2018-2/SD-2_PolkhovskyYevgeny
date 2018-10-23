package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Timetable;
import com.netcracker.edu.backend.repository.TimetableRepository;
import com.netcracker.edu.backend.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TimetableServiceImpl implements TimetableService {
   private TimetableRepository repository;
    @Autowired
    public TimetableServiceImpl(TimetableRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public Timetable saveTimetable(Timetable timetable) {
        return repository.save(timetable);
    }
    
    @Override
    public Optional<Timetable> getTimetableById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public Iterable<Timetable> getAllTimetables() {
        return repository.findAll();
    }
    
    @Override
    public void deleteTimetable(Long id) {
        repository.deleteById(id);
        
    }
}
