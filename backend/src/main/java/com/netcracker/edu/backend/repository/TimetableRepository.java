package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Timetable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends CrudRepository<Timetable,Long> {
}
