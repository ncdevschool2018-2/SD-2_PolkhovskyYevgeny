package com.netcracker.edu.backend.service.impl;


import com.netcracker.edu.backend.entity.SubjectTeacher;
import com.netcracker.edu.backend.repository.SubjectTeacherRepository;

import com.netcracker.edu.backend.service.SubjectTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubjectTeacherServiceImpl implements SubjectTeacherService {
    
    private SubjectTeacherRepository repository;
    
    @Autowired
    public SubjectTeacherServiceImpl(SubjectTeacherRepository repository){
        this.repository=repository;
    }
    
    @Override
    public SubjectTeacher saveSubjectTeacher(SubjectTeacher subjectTeacher) {
        return repository.save(subjectTeacher);
    }
    
    @Override
    public Optional<SubjectTeacher> getSubjectTeacherById(int id) {
        return repository.findById(id);
    }
    
    @Override
    public Iterable<SubjectTeacher> getAllSubjectTeacher() {
        return repository.findAll();
    }
    
    @Override
    public Integer[] getIdChoosenSubject(int subject) {
        return repository.findIdChoosenSubject(subject);
    }
    
    @Override
    public void deleteSubjectTeacher(int id) {
    repository.deleteById(id);
    }
}
