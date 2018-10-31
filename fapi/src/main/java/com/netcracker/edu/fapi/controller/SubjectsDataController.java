package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.SubjectsViewModel;
import com.netcracker.edu.fapi.service.SubjectsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectsDataController {
    @Autowired
    private SubjectsDataService subjectsDataService;
    
    @RequestMapping
    public ResponseEntity<List<SubjectsViewModel>> getAllSubjects() {
        return ResponseEntity.ok(subjectsDataService.getAll());
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SubjectsViewModel> saveSubjects(@RequestBody SubjectsViewModel subjects /*todo server validation*/) {
        if (subjects != null) {
            return ResponseEntity.ok(subjectsDataService.saveSubjects(subjects));
        }
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSubjects(@PathVariable String id) {
        subjectsDataService.deleteSubjects(Long.valueOf(id));
    }
}
