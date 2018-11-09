package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Teacher;
import com.netcracker.edu.backend.repository.TeacherRepository;
import com.netcracker.edu.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository repository;
    
    @Autowired
    public TeacherServiceImpl(TeacherRepository repository){
        this.repository=repository;
    }
    
    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return repository.save(teacher);
    }
    
    @Override
    public Optional<Teacher> getTeacherById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public Iterable<Teacher> getAllTeacher() {
        return repository.findAll();
    }
    
    @Override
    public void deleteTeacher(Long id) {
        repository.deleteById(id);
    }
    
    @Override
    public Teacher findTeacherByUserId(int userId) {
        return repository.findTeacherByUserId(userId);
    }
}
