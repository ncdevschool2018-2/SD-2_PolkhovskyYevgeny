package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.SlotsViewModel;
import com.netcracker.edu.fapi.service.SlotsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slot")
public class SlotsDataController {
    
    @Autowired
    private SlotsDataService slotsDataService;
    
    
    @RequestMapping
    public ResponseEntity<List<SlotsViewModel>> getAllSlots() {
        return ResponseEntity.ok(slotsDataService.getAll());
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SlotsViewModel> saveSlots(@RequestBody SlotsViewModel slots /*todo server validation*/) {
        if (slots != null) {
            return ResponseEntity.ok(slotsDataService.saveSlots(slots));
        }
        return null;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSlots(@PathVariable String id) {
        slotsDataService.deleteSlots(Integer.valueOf(id));
    }
}
