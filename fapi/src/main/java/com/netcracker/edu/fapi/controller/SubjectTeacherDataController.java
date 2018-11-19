package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.SubjectTeacherViewModel;
import com.netcracker.edu.fapi.service.SubjectTeacherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fsubject-teacher")
public class SubjectTeacherDataController {
    
    @Autowired
    private SubjectTeacherDataService subjectTeacherDataService;
    
    @RequestMapping
    public ResponseEntity<List<SubjectTeacherViewModel>> getAllSubjectTeacher() {
        return ResponseEntity.ok(subjectTeacherDataService.getAll());
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SubjectTeacherViewModel> saveSubjectTeacher(@RequestBody SubjectTeacherViewModel subjectTeacherViewModel /*todo server validation*/) {
        if (subjectTeacherViewModel != null) {
            return ResponseEntity.ok(subjectTeacherDataService.saveSubjectTeacher(subjectTeacherViewModel));
        }
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSubjectTeacher(@PathVariable String id) {
        subjectTeacherDataService.deleteSubjectTeacher(Integer.valueOf(id));
    }
}
