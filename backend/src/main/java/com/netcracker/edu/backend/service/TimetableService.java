package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Timetable;

import java.util.List;
import java.util.Optional;

public interface TimetableService {
    Timetable saveTimetable(Timetable timetable);
    Optional<Timetable> getTimetableById(Long id);
    Iterable<Timetable> getAllTimetable();
    List<Timetable> getAllByDayOfWeekIdAndGroupIdOrderBySlotId(int dayOfWeekId, int groupId);
    List<Timetable> getAllByGroupIdOrderByDayOfWeekId(int groupId);
    void deleteTimetable(Long id);
}
