package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Group;

import java.util.Optional;

public interface GroupService {
    Group saveGroup(Group group);
    Optional<Group> getGroupById(Long id);
    Iterable<Group> getAllGroups();
    void deleteGroup(Long id);
}
