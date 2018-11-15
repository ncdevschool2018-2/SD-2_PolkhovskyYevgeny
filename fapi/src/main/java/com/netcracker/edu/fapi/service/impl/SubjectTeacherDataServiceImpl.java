package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SubjectTeacherViewModel;
import com.netcracker.edu.fapi.service.SubjectTeacherDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubjectTeacherDataServiceImpl implements SubjectTeacherDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    @Override
    public List<SubjectTeacherViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        SubjectTeacherViewModel[] subjectTeacherViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/teacher-subject/all", SubjectTeacherViewModel[].class);
        return subjectTeacherViewModelResponse == null ? Collections.emptyList() : Arrays.asList(subjectTeacherViewModelResponse);
    
    }
    
    @Override
    public SubjectTeacherViewModel getSSubjectTeacherById(int id) {
        return null;
    }
    
    @Override
    public SubjectTeacherViewModel saveSubjectTeacher(SubjectTeacherViewModel subjectTeacherViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/teacher-subject", subjectTeacherViewModel, SubjectTeacherViewModel.class).getBody();
    
    }
    
    @Override
    public void deleteSubjectTeacher(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/teacher-subject/" + id);
    }
}
