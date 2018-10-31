package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.RolesViewModel;

import java.util.List;

public interface RolesDataService {
    List<RolesViewModel> getAll();
    RolesViewModel getRolesById(Long id);
    RolesViewModel saveRoles(RolesViewModel role);
    void deleteRoles(Long id);
}
