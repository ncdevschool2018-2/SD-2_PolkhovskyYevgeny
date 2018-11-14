package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Timetable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends CrudRepository<Timetable,Integer> {
    List<Timetable> findAllByDayOfWeekIdAndGroupIdOrderBySlotId(int dayOfWeekId, int groupId);
    List<Timetable> findAllByGroupIdOrderByDayOfWeekId(int groupId);
}
