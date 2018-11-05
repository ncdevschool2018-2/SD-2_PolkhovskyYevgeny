package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.backend.entity.UniversityGroup;
import com.netcracker.edu.fapi.models.UniversityGroupViewModel;
import com.netcracker.edu.fapi.service.UniversityGroupDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UniversityGroupDataServiceImpl implements UniversityGroupDataService {
    
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    @Override
    public List<UniversityGroupViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UniversityGroupViewModel[] universityGroupViewModelsResponse =
                restTemplate.getForObject(backendServerUrl + "/api/universitygroups/all", UniversityGroupViewModel[].class);
        return universityGroupViewModelsResponse == null ? Collections.emptyList() : Arrays.asList(universityGroupViewModelsResponse);
    }
    
    @Override
    public UniversityGroupViewModel getUniversityGroupById(Long id) {
        return null;
    }
    
    @Override
    public UniversityGroupViewModel saveUniversityGroup(UniversityGroupViewModel group) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/universitygroups", group, UniversityGroupViewModel.class).getBody();
    
    }
    
    @Override
    public void deleteUniversityGroup(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/universitygroups/" + id);
    
    }
    
    
    
}