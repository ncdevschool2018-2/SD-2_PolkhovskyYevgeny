package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.TimetableExampleViewModel;
import com.netcracker.edu.fapi.models.TimetableViewModel;

import java.util.List;

public interface TimetableDataService {
    List<TimetableViewModel> getAll();
    TimetableViewModel getTimetableById(int id);
    List<TimetableViewModel> getTimetableByGroupId(int id);
    List<TimetableExampleViewModel> getTimetableNamedByGroupId(int id);
    TimetableViewModel saveTimetable(TimetableViewModel timetable);
    void deleteTimetable(int id);
}
