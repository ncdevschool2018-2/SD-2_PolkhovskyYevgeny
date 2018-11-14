package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Pupils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PupilsRepository extends CrudRepository<Pupils, Integer> {
    
    List<Pupils> findByGroupId(int id);

}
