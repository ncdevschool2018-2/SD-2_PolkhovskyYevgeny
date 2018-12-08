package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.SubjectsViewModel;
import com.netcracker.edu.fapi.service.SubjectsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    
    
    @RequestMapping(value = "/dist", method = RequestMethod.GET)
    public ResponseEntity<List<SubjectsViewModel>> getDistinctSubject() {
        return ResponseEntity.ok(subjectsDataService.getDistinctSubject());
    }
    
    
    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<SubjectsViewModel>> getSubjectsForTeacher(@PathVariable int id) {
        return ResponseEntity.ok(subjectsDataService.getSubjectsForTeacher(id));
    }
    
    
    @RequestMapping(value = "/chooseIdfapi/{sub}", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> getIdChoosenSubject(@PathVariable String sub) {
        return ResponseEntity.ok(subjectsDataService.getIdChoosenSubject(sub));
    }
    
    
    @PreAuthorize("hasAnyAuthority('1')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SubjectsViewModel> saveSubjects(@RequestBody SubjectsViewModel subjects /*todo server validation*/) {
        if (subjects.getSubject().matches("[a-zA-Z]{2,30}")) {
            List<SubjectsViewModel> subjectsmass;
            subjectsmass = subjectsDataService.getAll();
            for (SubjectsViewModel sub : subjectsmass
            ) {
                if(sub.getSubject().equals(subjects.getSubject())){
                    return null;
                }
                
            }
            return ResponseEntity.ok(subjectsDataService.saveSubjects(subjects));
            
        } else {
            return null;
        }
    }
    
    
    @PreAuthorize("hasAnyAuthority('1')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSubjects(@PathVariable String id) {
        subjectsDataService.deleteSubjects(Integer.valueOf(id));
    }
}
