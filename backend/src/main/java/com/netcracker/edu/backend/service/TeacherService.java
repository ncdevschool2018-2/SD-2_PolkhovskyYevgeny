package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    Teacher saveTeacher(Teacher teacher);
    
    Optional<Teacher> getTeacherById(int id);
    
    Iterable<Teacher> getAllTeacher();
    
    List<Teacher> getAllByIdIsIn(Integer[] id);
    
    void deleteTeacher(int id);
    
    Page<Teacher> findAll(Pageable pageable);
    
    Teacher findTeacherByUserId(int userId);
}
