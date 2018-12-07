package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.NewUserViewModel;
import com.netcracker.edu.fapi.models.PageTeacherViewModel;
import com.netcracker.edu.fapi.models.TeacherViewModel;
import com.netcracker.edu.fapi.service.TeacherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherDataController {
    @Autowired
    private TeacherDataService teacherDataService;
    
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;
    
    
    @RequestMapping
    public ResponseEntity<List<TeacherViewModel>> getAllTeacher() {
        return ResponseEntity.ok(teacherDataService.getAll());
    }
    
    
    @RequestMapping(value = "/chooseTchr/{sbj}", method = RequestMethod.GET)
    public ResponseEntity<List<TeacherViewModel>> getTeachersSbj(@PathVariable int sbj) {
        return ResponseEntity.ok(teacherDataService.getTeachersSbj(sbj));
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TeacherViewModel> getTeacherById(@PathVariable int id) {
        return ResponseEntity.ok(teacherDataService.getTeacherById(id));
    }
    
    
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResponseEntity<PageTeacherViewModel> getTeacherPage(@RequestBody int page) {
        
        return ResponseEntity.ok(teacherDataService.getPageTeacher(page));
        
    }
    @RequestMapping(value = "/search/{word}", method = RequestMethod.GET)
    public ResponseEntity<List<TeacherViewModel>> findTeacher(@PathVariable String word) {
        
        return ResponseEntity.ok(teacherDataService.findTeacher(word));
        
    }
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/new-teacher")
    public ResponseEntity<TeacherViewModel> saveTeacher(@RequestBody NewUserViewModel teacher /*todo server validation*/) {
        if(teacher.getName().matches("[a-zA-Z]{3,10}")&&
        teacher.getSurname().matches("[a-zA-Z]{3,10}")&&
        teacher.getLogin().matches("[a-zA-Z0-9]{3,10}")&&
        teacher.getPassword().matches("[a-zA-Z0-9]{3,10}")){
        NewUserViewModel newTeacher =
                new NewUserViewModel(teacher.getName(), teacher.getSurname(), teacher.getSubjectId(), teacher.getGroupId(), teacher.getUserId(), teacher.getLogin(), bcryptEncoder.encode(teacher.getPassword()), teacher.getRoleId());
        
        if (newTeacher != null) {
            return ResponseEntity.ok(teacherDataService.saveTeacher(newTeacher));
        }
        return null;}
        else{
            return null;
        }
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable String id) {
        teacherDataService.deleteTeacher(Integer.valueOf(id));
    }
}
