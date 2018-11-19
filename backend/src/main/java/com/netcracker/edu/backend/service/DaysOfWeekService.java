package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.DaysOfWeek;

import java.util.Optional;

public interface DaysOfWeekService {
    DaysOfWeek saveDaysOfWeek(DaysOfWeek day);
    
    Optional<DaysOfWeek> getDaysOfWeekById(int id);
    
    Iterable<DaysOfWeek> getAllDaysOfWeek();
    
    void deleteDaysOfWeek(int id);
}
