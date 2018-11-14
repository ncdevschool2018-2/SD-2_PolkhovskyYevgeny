package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.RolesViewModel;
import com.netcracker.edu.fapi.service.RolesDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RolesDataServiceImpl implements RolesDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    
    @Override
    public List<RolesViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        RolesViewModel[] rolesViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/roles/all", RolesViewModel[].class);
        return rolesViewModelResponse == null ? Collections.emptyList() : Arrays.asList(rolesViewModelResponse);
    }
    
    @Override
    public RolesViewModel getRolesById(int id) {
        return null;
    }
    
    @Override
    public RolesViewModel saveRoles(RolesViewModel role) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/roles", role, RolesViewModel.class).getBody();
    
    }
    
    @Override
    public void deleteRoles(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/roles/" + id);
    }
}
