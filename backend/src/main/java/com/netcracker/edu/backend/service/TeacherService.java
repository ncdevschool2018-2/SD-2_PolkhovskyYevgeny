package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    Teacher saveTeacher(Teacher teacher);
    Optional<Teacher> getTeacherById(int id);
    Iterable<Teacher> getAllTeacher();
    List<Teacher> getAllByIdIsIn(Integer[] id);
    void deleteTeacher(int id);
    Teacher findTeacherByUserId(int userId);
}
