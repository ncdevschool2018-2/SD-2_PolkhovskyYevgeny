package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SubjectsViewModel;
import com.netcracker.edu.fapi.service.SubjectsDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubjectsDataServiceImpl  implements SubjectsDataService {
    
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    @Override
    public List<SubjectsViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        SubjectsViewModel[] subjectsViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/subjects/all", SubjectsViewModel[].class);
        return subjectsViewModelResponse == null ? Collections.emptyList() : Arrays.asList(subjectsViewModelResponse);
    }
    
    @Override
    public SubjectsViewModel getSubjectsById(Long id) {
        return null;
    }
    
    @Override
    public SubjectsViewModel saveSubjects(SubjectsViewModel subject) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subjects", subject, SubjectsViewModel.class).getBody();
    }
    
    @Override
    public void deleteSubjects(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/subjects/" + id);
    }
}
