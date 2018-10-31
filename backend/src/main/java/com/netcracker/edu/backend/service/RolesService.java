package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Roles;

import java.util.Optional;

public interface RolesService {
    Roles saveRoles(Roles role);
    Optional<Roles> getRolesById(Long id);
    Iterable<Roles> getAllRoles();
    void deleteRoles(Long id);
}
