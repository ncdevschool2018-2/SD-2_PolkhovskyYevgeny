package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Slots;

import java.util.Optional;

public interface SlotsService {
    Slots saveSlots(Slots slot);
    Optional<Slots> getSlotsById(int id);
    Iterable<Slots> getAllSlots();
    void deleteSlots(int id);
}
