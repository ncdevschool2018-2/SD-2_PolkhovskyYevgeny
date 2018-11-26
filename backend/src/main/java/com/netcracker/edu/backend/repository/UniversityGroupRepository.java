package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.UniversityGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityGroupRepository extends CrudRepository<UniversityGroup, Integer> {
    @Modifying
    @Query(value = "select * from university_group order by name", nativeQuery = true)
    List<UniversityGroup> findAllOrderByName();
    Page<UniversityGroup> findAll(Pageable pageable);
    
  
}
