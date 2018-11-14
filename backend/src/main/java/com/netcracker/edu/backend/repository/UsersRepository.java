package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Roles;
import com.netcracker.edu.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    Users findUserByLogin(String login);
}
