package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.TimetableViewModel;
import com.netcracker.edu.fapi.service.TimetableDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetable")
public class TimetableDataController {
    
    
    @Autowired
    private TimetableDataService timetableDataService;
    
    @RequestMapping
    public ResponseEntity<List<TimetableViewModel>> getAllTimetable() {
        return ResponseEntity.ok(timetableDataService.getAll());
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TimetableViewModel> saveTimetable(@RequestBody TimetableViewModel timetable /*todo server validation*/) {
        if (timetable != null) {
            return ResponseEntity.ok(timetableDataService.saveTimetable(timetable));
        }
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTimetable(@PathVariable String id) {
        timetableDataService.deleteTimetable(Long.valueOf(id));
    }
}
