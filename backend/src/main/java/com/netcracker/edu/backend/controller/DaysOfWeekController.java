package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.DaysOfWeek;
import com.netcracker.edu.backend.service.DaysOfWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/days-of-week")
public class DaysOfWeekController {
    private DaysOfWeekService daysOfWeekService;
    
    
    @Autowired
    public DaysOfWeekController(DaysOfWeekService daysOfWeekService) {
        this.daysOfWeekService = daysOfWeekService;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DaysOfWeek> getDaysOfWeekById(@PathVariable(name = "id") int id) {
        Optional<DaysOfWeek> daysOfWeek = daysOfWeekService.getDaysOfWeekById(id);
        if (daysOfWeek.isPresent()) {
            return ResponseEntity.ok(daysOfWeek.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<DaysOfWeek> getAllDaysOfWeek() {
        return daysOfWeekService.getAllDaysOfWeek();
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public DaysOfWeek saveDaysOfWeek(@RequestBody DaysOfWeek daysOfWeek) {
        return daysOfWeekService.saveDaysOfWeek(daysOfWeek);
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDaysOfWeek(@PathVariable(name = "id") int id) {
        daysOfWeekService.deleteDaysOfWeek(id);
        return ResponseEntity.noContent().build();
    }
}
