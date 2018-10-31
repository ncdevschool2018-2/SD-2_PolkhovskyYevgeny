package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Slots;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotsRepository extends CrudRepository<Slots,Long> {
}
