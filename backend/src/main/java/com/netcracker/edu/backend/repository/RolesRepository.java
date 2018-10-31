package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<Roles,Long> {
}
