package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Teacher;
import com.netcracker.edu.backend.repository.TeacherRepository;
import com.netcracker.edu.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository repository;
    
    
    @Autowired
    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }
    
    
    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return repository.save(teacher);
    }
    
    
    @Override
    public Optional<Teacher> getTeacherById(int id) {
        return repository.findById(id);
    }
    
    
    @Override
    public Iterable<Teacher> getAllTeacher() {
        return repository.findAll();
    }
    
    
    @Override
    public List<Teacher> getAllByIdIsIn(Integer[] id) {
        return repository.findAllByIdIsIn(id);
    }
    
    
    @Override
    public void deleteTeacher(int id) {
        repository.deleteById(id);
    }
    
    
    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    
    
    @Override
    public Teacher findTeacherByUserId(int userId) {
        return repository.findTeacherByUserId(userId);
    }
    
    
    @Override
    public List<Teacher> findTeacher(String word) {
        return repository.findTeacher(word);
    }
}
