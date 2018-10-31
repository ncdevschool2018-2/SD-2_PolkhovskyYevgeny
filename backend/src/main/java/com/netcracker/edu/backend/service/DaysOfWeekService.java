package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.DaysOfWeek;

import java.util.Optional;

public interface DaysOfWeekService {
    DaysOfWeek saveDaysOfWeek(DaysOfWeek day);
    Optional<DaysOfWeek> getDaysOfWeekById(Long id);
    Iterable<DaysOfWeek> getAllDaysOfWeek();
    void deleteDaysOfWeek(Long id);
}
