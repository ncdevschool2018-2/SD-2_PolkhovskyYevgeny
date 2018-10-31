package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Subjects;

import java.util.Optional;

public interface SubjectsService {
    Subjects saveSubjects(Subjects subject);
    Optional<Subjects> getSubjectsById(Long id);
    Iterable<Subjects> getAllSubjects();
    void deleteSubjects(Long id);
}
