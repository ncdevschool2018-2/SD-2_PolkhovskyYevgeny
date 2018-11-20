package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.dto.TeacherDto;
import com.netcracker.edu.backend.entity.Teacher;
import com.netcracker.edu.backend.service.TeacherService;
import com.netcracker.edu.backend.service.businesService.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private TeacherService teacherService;
    private RegistrationService registrationService;
    @Autowired
    public TeacherController(TeacherService teacherService,RegistrationService registrationService) {
        this.teacherService = teacherService;
        this.registrationService=registrationService;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Teacher> getTeacherById(@PathVariable(name = "id") int id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        if (teacher.isPresent()) {
            return ResponseEntity.ok(teacher.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }
    
    @RequestMapping(value = "/user-id/{user-id}", method = RequestMethod.GET)
    public Teacher findTeacherByUserId(@PathVariable(name = "user-id") int userId) {
        return teacherService.findTeacherByUserId(userId);
    }
    
    @RequestMapping(value = "/chooseTeacher/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Teacher>> getAllByIdIsIn(@PathVariable(name = "id") Integer[] id) {
        List<Teacher> teachers = teacherService.getAllByIdIsIn(id);
        
        
        if (teachers != null) {
            return ResponseEntity.ok(teachers);
        } else {
            return ResponseEntity.notFound().build();
            
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Teacher registrateTeacher(@RequestBody TeacherDto teacherDto) {
        return registrationService.registrateTeacher(teacherDto);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTeacher(@PathVariable(name = "id") int id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}
