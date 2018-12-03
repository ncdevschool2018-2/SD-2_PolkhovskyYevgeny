package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Timetable;
import com.netcracker.edu.backend.repository.TimetableRepository;
import com.netcracker.edu.backend.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
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
    public Optional<Timetable> getTimetableById(int id) {
        return repository.findById(id);
    }
    
    
    @Override
    public Iterable<Timetable> getAllTimetable() {
        return repository.findAll();
    }
    
    
    @Override
    public List<Timetable> getAllByDayOfWeekIdAndGroupIdOrderBySlotId(int dayOfWeekId, int groupId) {
        if (repository.findAllByDayOfWeekIdAndGroupIdOrderBySlotId(dayOfWeekId, groupId) == null) {
            return Collections.emptyList();
            
        } else {
            return repository.findAllByDayOfWeekIdAndGroupIdOrderBySlotId(dayOfWeekId, groupId);
        }
    }
    
    
    @Override
    public List<Timetable> getAllByDayOfWeekIdAndTeacherIdOrderBySlotId(int dayOfWeekId, int teacherId) {
        if (repository.findAllByDayOfWeekIdAndTeacherIdOrderBySlotId(dayOfWeekId, teacherId) == null) {
            return Collections.emptyList();
            
        } else {
            return repository.findAllByDayOfWeekIdAndTeacherIdOrderBySlotId(dayOfWeekId, teacherId);
        }
    }
    
    
    @Override
    public List<Timetable> getAllByGroupIdOrderByDayOfWeekId(int groupId) {
        return repository.findAllByGroupIdOrderByDayOfWeekId(groupId);
    }
    
    
    @Override
    public void deleteTimetable(int id) {
        repository.deleteById(id);
    }
}
