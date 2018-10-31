package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.TimetableViewModel;

import java.util.List;

public interface TimetableDataService {
    List<TimetableViewModel> getAll();
    TimetableViewModel getTimetableById(Long id);
    TimetableViewModel saveTimetable(TimetableViewModel timetable);
    void deleteTimetable(Long id);
}
