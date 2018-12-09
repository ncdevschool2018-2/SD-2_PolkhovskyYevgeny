package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.TeacherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TeacherDataServiceImpl implements TeacherDataService {
    
    UsersDataServiceImpl usersDataService;
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    
    @Autowired
    public TeacherDataServiceImpl(UsersDataServiceImpl usersDataService) {
        this.usersDataService = usersDataService;
    }
    
    
    @Override
    public List<TeacherViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        TeacherViewModel[] teacherViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/teachers/all", TeacherViewModel[].class);
        return teacherViewModelResponse == null ? Collections.emptyList() : Arrays.asList(teacherViewModelResponse);
    }
    
    
    @Override
    public List<TeacherViewModel> getTeachersSbj(int sbj) {
        RestTemplate restTemplate = new RestTemplate();
        Integer[] chooseSbjId =
                restTemplate.getForObject(backendServerUrl + "/api/teacher-subject/chooseId/" + sbj, Integer[].class);
        if (chooseSbjId == null) {
            return null;
        }
        Arrays.asList(chooseSbjId);
        String s = "";
        for (int i = 0; i < chooseSbjId.length; i++) {
            s += chooseSbjId[i] + ",";
        }
        System.out.println(s);
        TeacherViewModel[] teacherViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/teachers/chooseTeacher/" + s, TeacherViewModel[].class);
        return teacherViewModelResponse == null ? Collections.emptyList() : Arrays.asList(teacherViewModelResponse);
    }
    
    
    @Override
    public TeacherViewModel getTeacherById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        TeacherViewModel teacherViewModelResp =
                restTemplate.getForObject(backendServerUrl + "/api/teachers/" + id, TeacherViewModel.class);
        return teacherViewModelResp;
    }
    
    
    @Override
    public TeacherViewModel saveTeacher(NewUserViewModel newTeacherViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        NewTeacherViewModel newTeacher =
                new NewTeacherViewModel(newTeacherViewModel.getName(), newTeacherViewModel.getSurname(), newTeacherViewModel.getSubjectId(), newTeacherViewModel.getUserId(), newTeacherViewModel.getLogin(), newTeacherViewModel.getPassword(), newTeacherViewModel.getRoleId());
        
        List<UsersViewModel> usersViewModels = usersDataService.getAll();
        for (UsersViewModel user : usersViewModels
        ) {if(user.getLogin().equals(newTeacherViewModel.getLogin())){
            return null;
        }
        
        }
        NewTeacherViewModel teacher = restTemplate.postForEntity(backendServerUrl + "/api/teachers", newTeacher, NewTeacherViewModel.class).getBody();
        return new TeacherViewModel();
        
    }
    
    /*@Override
    public TeacherViewModel saveTeacher(NewUserViewModel newTeacherViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        UsersViewModel newUser = new UsersViewModel(newTeacherViewModel.getLogin(), newTeacherViewModel.getPassword(), newTeacherViewModel.getRoleId());
        UsersViewModel user = restTemplate.postForEntity(backendServerUrl + "/api/users", newUser, UsersViewModel.class).getBody();
        if (user == null) {
            return null;
        }
        UsersViewModel userLogin = restTemplate.getForObject(backendServerUrl + "/api/users/login/" + user.getLogin(), UsersViewModel.class);
        if (userLogin == null) {
            return null;
        }
        TeacherViewModel newTeacher = new TeacherViewModel(newTeacherViewModel.getName(), newTeacherViewModel.getSurname(), userLogin.getId());
        TeacherViewModel teacher = restTemplate.postForEntity(backendServerUrl + "/api/teachers", newTeacher, TeacherViewModel.class).getBody();
        if (teacher == null) {
            return null;
        }
        TeacherViewModel teacherUserId = restTemplate.getForObject(backendServerUrl + "api/teachers/login/" + teacher.getUserId(), TeacherViewModel.class);
        if (teacherUserId == null) {
            return null;
        }
        SubjectTeacherViewModel newSubjectTeacher = new SubjectTeacherViewModel(newTeacherViewModel.getSubjectId(), teacherUserId.getId());
        SubjectTeacherViewModel subjectTeacher = restTemplate.postForEntity(backendServerUrl + "/api/teacher-subject", newSubjectTeacher, SubjectTeacherViewModel.class).getBody();
        return teacher;
        
    }*/
    
    
    @Override
    public void deleteTeacher(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/teachers/" + id);
    }
    
    
    @Override
    public TeacherViewModel findTeacherByUserId(int userId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/teachers/user-id/" + userId, TeacherViewModel.class);
        
    }
    
    
    @Override
    public PageTeacherViewModel getPageTeacher(int page) {
        RestTemplate restTemplate = new RestTemplate();
        
        return restTemplate.postForEntity(backendServerUrl + "/api/teachers/list", page, PageTeacherViewModel.class).getBody();
        
    }
    
    
    @Override
    public List<TeacherViewModel> findTeacher(String word) {
        RestTemplate restTemplate = new RestTemplate();
        
        TeacherViewModel[] teacherViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/teachers/search/" + word, TeacherViewModel[].class);
        return teacherViewModelResponse == null ? Collections.emptyList() : Arrays.asList(teacherViewModelResponse);
        
    }
    
}
