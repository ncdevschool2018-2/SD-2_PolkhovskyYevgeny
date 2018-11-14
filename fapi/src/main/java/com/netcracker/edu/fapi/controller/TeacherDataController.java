package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.NewUserViewModel;
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
    
    @RequestMapping(value = "/chooseTchr/{sbj}",method = RequestMethod.GET)
    public ResponseEntity<List<TeacherViewModel>> getTeachersSbj(@PathVariable String sbj) {
        return ResponseEntity.ok(teacherDataService.getTeachersSbj(sbj));
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TeacherViewModel> getTeacherById(@PathVariable int id) {
        return ResponseEntity.ok(teacherDataService.getTeacherById(id));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/new-teacher")
    public ResponseEntity<TeacherViewModel> saveTeacher(@RequestBody NewUserViewModel teacher /*todo server validation*/) {
        if (teacher != null) {
            return ResponseEntity.ok(teacherDataService.saveTeacher(teacher));
        }
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable String id) {
        teacherDataService.deleteTeacher(Integer.valueOf(id));
    }
}
