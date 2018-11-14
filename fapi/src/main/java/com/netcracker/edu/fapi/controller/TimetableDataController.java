package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.TimetableExampleViewModel;
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
    
    @RequestMapping(value = "group/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<TimetableViewModel>>getTimetableByGroupId(@PathVariable int id){
        return ResponseEntity.ok(timetableDataService.getTimetableByGroupId(id));
    }
    
    @RequestMapping(value = "group/named/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<TimetableExampleViewModel>>getTimetableNamedByGroupId(@PathVariable int id){
        return ResponseEntity.ok(timetableDataService.getTimetableNamedByGroupId(id));
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
        timetableDataService.deleteTimetable(Integer.valueOf(id));
    }
}
