package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.GroupViewModel;
import com.netcracker.edu.fapi.service.GroupDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class GroupDataServiceImpl implements GroupDataService {
    
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    @Override
    public List<GroupViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        GroupViewModel[] groupViewModelsResponse =
                restTemplate.getForObject(backendServerUrl + "/api/groups/all", GroupViewModel[].class);
        return groupViewModelsResponse == null ? Collections.emptyList() : Arrays.asList(groupViewModelsResponse);
    }
    
    @Override
    public GroupViewModel getGroupById(Long id) {
        return null;
    }
    
    @Override
    public GroupViewModel saveGroup(GroupViewModel group) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/groups", group, GroupViewModel.class).getBody();
    
    }
    
    @Override
    public void deleteGroup(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/groups/" + id);
    
    }
}
