package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Timetable;

import java.util.List;
import java.util.Optional;

public interface TimetableService {
    Timetable saveTimetable(Timetable timetable);
    Optional<Timetable> getTimetableById(int id);
    Iterable<Timetable> getAllTimetable();
    List<Timetable> getAllByDayOfWeekIdAndGroupIdOrderBySlotId(int dayOfWeekId, int groupId);
    List<Timetable> getAllByDayOfWeekIdAndTeacherIdOrderBySlotId(int dayOfWeekId, int teacherId);
    List<Timetable> getAllByGroupIdOrderByDayOfWeekId(int groupId);
    void deleteTimetable(int id);
}
