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
    public SubjectsViewModel getSubjectsById(int id) {
        return null;
    }
    
    @Override
    public List<SubjectsViewModel> getDistinctSubject() {
        RestTemplate restTemplate = new RestTemplate();
        SubjectsViewModel[] subjectsViewModelsResponse=
                restTemplate.getForObject(backendServerUrl+"/api/subjects/dist",SubjectsViewModel[].class);
        return subjectsViewModelsResponse == null ? Collections.emptyList() : Arrays.asList(subjectsViewModelsResponse);
    }
    
    @Override
    public List<SubjectsViewModel> getSubjectsForTeacher(int id) {
        RestTemplate restTemplate= new RestTemplate();
        SubjectsViewModel[] subjectsViewModelsResponse=
                restTemplate.getForObject(backendServerUrl+"/api/subjects/teacher/"+id,SubjectsViewModel[].class);
        return subjectsViewModelsResponse==null ?Collections.emptyList():Arrays.asList(subjectsViewModelsResponse);
    }
    
    @Override
    public List<Integer> getIdChoosenSubject(String subject) {
        RestTemplate restTemplate = new RestTemplate();
        Integer[] chooseSbjId=
                restTemplate.getForObject(backendServerUrl+"/api/subjects/chooseId/"+subject,Integer[].class);
        return chooseSbjId == null ? Collections.emptyList() : Arrays.asList(chooseSbjId);
    
    }
    
    @Override
    public SubjectsViewModel saveSubjects(SubjectsViewModel subject) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subjects", subject, SubjectsViewModel.class).getBody();
    }
    
    @Override
    public void deleteSubjects(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/subjects/" + id);
    }
}
