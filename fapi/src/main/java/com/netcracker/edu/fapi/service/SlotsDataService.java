package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.SlotsViewModel;

import java.util.List;

public interface SlotsDataService {
    List<SlotsViewModel> getAll();
    
    SlotsViewModel getSlotsById(int id);
    
    SlotsViewModel saveSlots(SlotsViewModel slot);
    
    void deleteSlots(int id);
}
