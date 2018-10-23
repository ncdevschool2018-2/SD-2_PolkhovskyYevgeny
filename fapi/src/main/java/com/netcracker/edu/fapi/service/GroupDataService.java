package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.GroupViewModel;

import java.util.List;

public interface GroupDataService {
    List<GroupViewModel> getAll();
    GroupViewModel getGroupById(Long id);
    GroupViewModel saveGroup(GroupViewModel group);
    void deleteGroup(Long id);
}
