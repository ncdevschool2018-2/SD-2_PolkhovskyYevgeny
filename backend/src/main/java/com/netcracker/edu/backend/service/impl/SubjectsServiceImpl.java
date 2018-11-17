package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Subjects;
import com.netcracker.edu.backend.repository.SubjectsRepository;
import com.netcracker.edu.backend.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubjectsServiceImpl implements SubjectsService {
    
    private SubjectsRepository repository;
    
    @Autowired
    public SubjectsServiceImpl(SubjectsRepository repository){
        this.repository=repository;
    }
    
    @Override
    public Subjects saveSubjects(Subjects subject) {
        return repository.save(subject);
    }
    
    @Override
    public Optional<Subjects> getSubjectsById(int id) {
        return repository.findById(id);
    }
    
    @Override
    public Iterable<Subjects> getAllSubjects() {
        return repository.findAll();
    }
    
    @Override
    public List<Subjects> getSubjectsForTeacher(int teacherId) {
        return repository.findSubjectsForTeacher(teacherId);
    }
    
    @Override
    public List<Subjects> getDistinctSubject() {
        return repository.findDistinctSubject();
    }
    
    @Override
    public List<Subjects> getAllBySubject(String subject) {
        return repository.findAllBySubject(subject);
    }
    
   /* @Override
    public Integer[] getIdChoosenSubject(String subject) {
        return repository.findIdChoosenSubject(subject);
    }*/
    
    
    @Override
    public void deleteSubjects(int id) {
        repository.deleteById(id);
    }
}
