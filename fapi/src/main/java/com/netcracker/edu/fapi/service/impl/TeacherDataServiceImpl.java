package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.TeacherViewModel;
import com.netcracker.edu.fapi.service.TeacherDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TeacherDataServiceImpl implements TeacherDataService {
    
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    @Override
    public List<TeacherViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        TeacherViewModel[] teacherViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/teachers/all", TeacherViewModel[].class);
        return teacherViewModelResponse == null ? Collections.emptyList() : Arrays.asList(teacherViewModelResponse);
    }
    
    @Override
    public TeacherViewModel getTeacherById(Long id) {
        return null;
    }
    
    @Override
    public TeacherViewModel saveTeacher(TeacherViewModel teacher) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/teachers", teacher, TeacherViewModel.class).getBody();
    }
    
    @Override
    public void deleteTeacher(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/teachers/" + id);
    }
}
