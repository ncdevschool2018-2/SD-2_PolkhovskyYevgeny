package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Teacher;

import java.util.Optional;

public interface TeacherService {
    Teacher saveTeacher(Teacher teacher);
    Optional<Teacher> getTeacherById(Long id);
    Iterable<Teacher> getAllTeacher();
    void deleteTeacher(Long id);
}
