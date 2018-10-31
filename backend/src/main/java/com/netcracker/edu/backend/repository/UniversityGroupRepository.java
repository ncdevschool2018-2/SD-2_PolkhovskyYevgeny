package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.backend.entity.UniversityGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UniversityGroupRepository extends CrudRepository<UniversityGroup,Long> {

}
