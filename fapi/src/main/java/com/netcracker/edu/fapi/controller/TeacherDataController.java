package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.TeacherViewModel;
import com.netcracker.edu.fapi.service.TeacherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherDataController {
    @Autowired
    private TeacherDataService teacherDataService;
    
    @RequestMapping
    public ResponseEntity<List<TeacherViewModel>> getAllTeacher() {
        return ResponseEntity.ok(teacherDataService.getAll());
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TeacherViewModel> saveTeacher(@RequestBody TeacherViewModel teacher /*todo server validation*/) {
        if (teacher != null) {
            return ResponseEntity.ok(teacherDataService.saveTeacher(teacher));
        }
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable String id) {
        teacherDataService.deleteTeacher(Long.valueOf(id));
    }
}
