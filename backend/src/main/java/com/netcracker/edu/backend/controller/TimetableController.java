package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Timetable;
import com.netcracker.edu.backend.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/timetables")
public class TimetableController {
    private TimetableService timetableService;
    
    @Autowired
    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Timetable> getTimetableById(@PathVariable(name = "id") Long id) {
        Optional<Timetable> timetable = timetableService.getTimetableById(id);
        if (timetable.isPresent()) {
            return ResponseEntity.ok(timetable.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Timetable> getAllTimetable() {
        return timetableService.getAllTimetable();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Timetable saveTimetable(@RequestBody Timetable timetable) {
        return timetableService.saveTimetable(timetable);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTimetable(@PathVariable(name = "id") Long id) {
        timetableService.deleteTimetable(id);
        return ResponseEntity.noContent().build();
    }
}