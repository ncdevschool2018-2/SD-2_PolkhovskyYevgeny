package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.DaysOfWeek;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaysOfWeekRepository extends CrudRepository<DaysOfWeek, Integer> {

}
