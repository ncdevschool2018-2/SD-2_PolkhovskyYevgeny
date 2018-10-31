package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Subjects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends CrudRepository<Subjects,Long> {
}
