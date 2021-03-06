package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Timetable;
import com.netcracker.edu.backend.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<Timetable> getTimetableById(@PathVariable(name = "id") int id) {
        Optional<Timetable> timetable = timetableService.getTimetableById(id);
        if (timetable.isPresent()) {
            return ResponseEntity.ok(timetable.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @RequestMapping(value = "/day/{day}/{group}", method = RequestMethod.GET)
    public ResponseEntity<List<Timetable>> getAllByDayOfWeekIdAndGroupIdOrderBySlotId(@PathVariable(name = "day") int day, @PathVariable(name = "group") int group) {
        List<Timetable> timetable = timetableService.getAllByDayOfWeekIdAndGroupIdOrderBySlotId(day, group);
        if (timetable != null) {
            return ResponseEntity.ok(timetable);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @RequestMapping(value = "/day/{day}/teacher/{teacher}", method = RequestMethod.GET)
    public ResponseEntity<List<Timetable>> getAllByDayOfWeekIdAndTeacherIdOrderBySlotId(@PathVariable(name = "day") int day, @PathVariable(name = "teacher") int teacher) {
        List<Timetable> timetable = timetableService.getAllByDayOfWeekIdAndTeacherIdOrderBySlotId(day, teacher);
        if (timetable != null) {
            return ResponseEntity.ok(timetable);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @RequestMapping(value = "/day/{day}/group/{group}/slot/{slot}", method = RequestMethod.GET)
    public ResponseEntity<Timetable> getByDayOfWeekIdAndGroupIdAndSlotId(@PathVariable(name = "day") int dayOfWeekId, @PathVariable(name = "group") int groupId, @PathVariable(name = "slot") int slotId) {
        Timetable timetable = timetableService.getByDayOfWeekIdAndGroupIdAndSlotId(dayOfWeekId, groupId, slotId);
        if (timetable != null) {
            return ResponseEntity.ok(timetable);
        } else {
            return ResponseEntity.ok(timetable);
        }
    }
    
    
    @RequestMapping(value = "/pupil/{group}", method = RequestMethod.GET)
    public ResponseEntity<List<Timetable>> getAllByGroupIdOrderByDayOfWeekId(@PathVariable(name = "group") int group) {
        List<Timetable> timetable = timetableService.getAllByGroupIdOrderByDayOfWeekId(group);
        if (timetable != null) {
            return ResponseEntity.ok(timetable);
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
    public ResponseEntity deleteTimetable(@PathVariable(name = "id") int id) {
        timetableService.deleteTimetable(id);
        return ResponseEntity.noContent().build();
    }
}
