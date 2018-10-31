package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.DaysOfWeekViewModel;

import java.util.List;

public interface DaysOfWeekDataService {
    List<DaysOfWeekViewModel> getAll();
    DaysOfWeekViewModel getDaysOfWeekById(Long id);
    DaysOfWeekViewModel saveDaysOfWeek(DaysOfWeekViewModel day);
    void deleteDaysOfWeek(Long id);
}
