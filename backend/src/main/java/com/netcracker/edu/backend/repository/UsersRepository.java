package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findUserByLogin(String login);
}
