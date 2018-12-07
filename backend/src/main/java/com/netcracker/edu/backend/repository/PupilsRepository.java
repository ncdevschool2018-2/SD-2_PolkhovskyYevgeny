package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Pupils;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PupilsRepository extends CrudRepository<Pupils, Integer> {
    
    List<Pupils> findByGroupIdOrderBySurname(int id);
    
    @Query("SELECT p FROM Pupils p where (p.surname like %:surname% or " +
            "p.name like %:name%) and p.groupId=:groupId ORDER BY p.surname asc  ")
    List<Pupils> findPupilBySurnameAndName(@Param("surname") String surname, @Param("name") String name, @Param("groupId")int groupId );
    
    Pupils findByUserId(int userId);
    
    
}
