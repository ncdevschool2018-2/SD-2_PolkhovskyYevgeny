package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.DaysOfWeekViewModel;
import com.netcracker.edu.fapi.service.DaysOfWeekDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/day-of-week")
public class DaysOfWeekDataController {
    
    @Autowired
    private DaysOfWeekDataService daysOfWeekDataService;
    
    
    @RequestMapping
    public ResponseEntity<List<DaysOfWeekViewModel>> getAllDaysOfWeek() {
        return ResponseEntity.ok(daysOfWeekDataService.getAll());
    }
    
    @PreAuthorize("hasAnyAuthority('1')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<DaysOfWeekViewModel> saveDaysOfWeek(@RequestBody DaysOfWeekViewModel daysOfWeek /*todo server validation*/) {
        if (daysOfWeek != null) {
            return ResponseEntity.ok(daysOfWeekDataService.saveDaysOfWeek(daysOfWeek));
        }
        return null;
    }
    
    @PreAuthorize("hasAnyAuthority('1')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDaysOfWeek(@PathVariable String id) {
        daysOfWeekDataService.deleteDaysOfWeek(Integer.valueOf(id));
    }
}
