package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Timetable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends CrudRepository<Timetable,Integer> {
    List<Timetable> findAllByDayOfWeekIdAndGroupIdOrderBySlotId(int dayOfWeekId, int groupId);
    
    @Modifying
    @Query(value = "select * from timetable inner join subject_teacher on timetable.subject_id=subject_teacher.id where timetable.day_of_week_id=?1 and subject_teacher.teacher_id=?2",nativeQuery = true)
    List<Timetable> findAllByDayOfWeekIdAndTeacherIdOrderBySlotId(int dayOfWeekId, int teacherId);
    List<Timetable> findAllByGroupIdOrderByDayOfWeekId(int groupId);
}
