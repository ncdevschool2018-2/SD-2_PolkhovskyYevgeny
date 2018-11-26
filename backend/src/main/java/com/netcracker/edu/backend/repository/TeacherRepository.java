package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Teacher;
import com.netcracker.edu.backend.entity.UniversityGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    Teacher findTeacherByUserId(int userId);
    
    @Modifying
    @Query(value = "select * from teacher where id in (?1)", nativeQuery = true)
    List<Teacher> findAllByIdIsIn(Integer[] id);
    Page<Teacher> findAll(Pageable pageable);
}
