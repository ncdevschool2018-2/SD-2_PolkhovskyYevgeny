package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Roles;

import java.util.Optional;

public interface RolesService {
    Roles saveRoles(Roles role);
    Optional<Roles> getRolesById(int id);
    Iterable<Roles> getAllRoles();
    void deleteRoles(int id);
}
