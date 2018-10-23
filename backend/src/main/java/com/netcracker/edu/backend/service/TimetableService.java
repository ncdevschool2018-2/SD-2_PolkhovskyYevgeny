package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Timetable;

import java.util.Optional;

public interface TimetableService {
    Timetable saveTimetable(Timetable timetable);
    Optional<Timetable> getTimetableById(Long id);
    Iterable<Timetable> getAllTimetables();
    void deleteTimetable(Long id);
}
