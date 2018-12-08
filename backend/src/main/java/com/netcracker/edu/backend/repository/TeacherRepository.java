package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    Teacher findTeacherByUserId(int userId);
    
    @Modifying
    @Query(value = "select * from teacher where id in (?1)", nativeQuery = true)
    List<Teacher> findAllByIdIsIn(Integer[] id);
    
    Page<Teacher> findAll(Pageable pageable);
    
    @Query("SELECT t FROM Teacher t where t.name like  %:word% or t.surname like  %:word% ORDER BY t.name asc  " )
    List<Teacher> findTeacher(@Param("word") String  word);
    
    Teacher findByUserId(int userId);
}
