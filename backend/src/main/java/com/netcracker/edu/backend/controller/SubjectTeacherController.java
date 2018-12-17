package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.SubjectTeacher;
import com.netcracker.edu.backend.service.SubjectTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/teacher-subject")
public class SubjectTeacherController {
    private SubjectTeacherService subjectTeacherService;
    
    
    @Autowired
    public SubjectTeacherController(SubjectTeacherService subjectTeacherService) {
        this.subjectTeacherService = subjectTeacherService;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubjectTeacher> getSubjectTeacherById(@PathVariable(name = "id") int id) {
        Optional<SubjectTeacher> slots = subjectTeacherService.getSubjectTeacherById(id);
        if (slots.isPresent()) {
            return ResponseEntity.ok(slots.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @RequestMapping(value = "/chooseId/{sub}", method = RequestMethod.GET)
    public ResponseEntity<Integer[]> getIdChoosenSubject(@PathVariable(name = "sub") int sub) {
        Integer[] subjects = subjectTeacherService.getIdChoosenSubject(sub);
        
        
        if (subjects != null) {
            return ResponseEntity.ok(subjects);
        } else {
            return null;
            
        }
    }
    
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<SubjectTeacher> getAllSubjectTeacher() {
        return subjectTeacherService.getAllSubjectTeacher();
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public SubjectTeacher saveSubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
        return subjectTeacherService.saveSubjectTeacher(subjectTeacher);
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteSubjectTeacher(@PathVariable(name = "id") int id) {
        subjectTeacherService.deleteSubjectTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
