package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.SubjectTeacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTeacherRepository extends CrudRepository<SubjectTeacher, Integer> {
    @Modifying
    @Query(value = "select teacher_id from subject_teacher where subject_id=?1", nativeQuery = true)
    Integer[] findIdChoosenSubject(int subject);
}
