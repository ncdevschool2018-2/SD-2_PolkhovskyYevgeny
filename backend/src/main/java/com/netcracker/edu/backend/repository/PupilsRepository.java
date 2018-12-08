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
    
    @Query("SELECT p FROM Pupils p where (p.surname like %:surname% and " +
            "p.name like %:name%) and p.groupId=:groupId ORDER BY p.surname asc  ")
    List<Pupils> findPupilBySurnameAndName(@Param("surname") String surname, @Param("name") String name, @Param("groupId")int groupId );
    
    @Query("SELECT p FROM Pupils p where p.surname like %:surname% " +
            " and p.groupId=:groupId ORDER BY p.surname asc  ")
    List<Pupils> findPupilBySurname(@Param("surname") String surname,  @Param("groupId")int groupId );
    
    @Query("SELECT p FROM Pupils p where  " +
            "p.name like %:name% and p.groupId=:groupId ORDER BY p.surname asc  ")
    List<Pupils> findPupilByName( @Param("name") String name, @Param("groupId")int groupId );
    
    Pupils findByUserId(int userId);
    
    
}
