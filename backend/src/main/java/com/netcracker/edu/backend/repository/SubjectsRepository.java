package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Subjects;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectsRepository extends CrudRepository<Subjects, Integer> {
    @Modifying
    @Query(value = "select distinct id,subject,teacher_id from subjects group by subject", nativeQuery = true)
    List<Subjects> findDistinctSubject();
    
    List<Subjects> findAllBySubject(String subject);
    
    @Modifying
    @Query(value = "select distinct teacher_id from subjects where subject=?1", nativeQuery = true)
    Integer[] findIdChoosenSubject(String subject);
    
    @Modifying
    @Query(value = "select * from subjects inner join subject_teacher on subjects.id=subject_teacher.subject_id where subject_teacher.teacher_id=?1", nativeQuery = true)
    List<Subjects> findSubjectsForTeacher(int teacherId);
    
    @Modifying
    @Query(value = "SELECT * FROM subjects ORDER BY subject LIMIT 10 OFFSET ?1", nativeQuery = true)
    List<Subjects> findSubjectsPage(int offset);
    
    @Modifying
    @Query(value = "SELECT COUNT (*) FROM subjects", nativeQuery = true)
    Integer getTotalPages();
    
    @Query("SELECT u FROM Subjects u where u.subject like %:word%  ORDER BY u.subject asc  ")
    List<Subjects> findSubjects(@Param("word") String word);
}
