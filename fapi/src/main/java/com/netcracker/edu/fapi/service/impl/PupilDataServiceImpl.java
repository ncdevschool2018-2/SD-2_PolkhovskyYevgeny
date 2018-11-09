package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.NewUserViewModel;
import com.netcracker.edu.fapi.models.PupilViewModel;
import com.netcracker.edu.fapi.models.UsersViewModel;
import com.netcracker.edu.fapi.service.PupilDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PupilDataServiceImpl  implements PupilDataService {
    
    
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    @Override
    public List<PupilViewModel> getAll() {
        RestTemplate restTemplate =new RestTemplate();
        PupilViewModel[] pupilViewModelResponse=
                restTemplate.getForObject(backendServerUrl+"/api/pupils/all", PupilViewModel[].class);
        return pupilViewModelResponse == null? Collections.emptyList(): Arrays.asList(pupilViewModelResponse);
    }
    
    @Override
    public PupilViewModel getPupilById(Long id) {
       
        return null;
    }
    
    @Override
    public PupilViewModel savePupil(NewUserViewModel newPupilViewModel) {
        RestTemplate restTemplate =new RestTemplate();
        UsersViewModel newUser = new UsersViewModel(newPupilViewModel.getLogin(),newPupilViewModel.getPassword(),newPupilViewModel.getRoleId());
        UsersViewModel user = restTemplate.postForEntity(backendServerUrl + "/api/users", newUser, UsersViewModel.class).getBody();
    
        if (user==null){
            return null;
        }
        UsersViewModel userLogin = restTemplate.getForObject(backendServerUrl + "/api/users/login/" + user.getLogin(), UsersViewModel.class);
        if (userLogin == null) {
            return null;
        }
        PupilViewModel newPupil = new PupilViewModel(newPupilViewModel.getName(),newPupilViewModel.getSurname(),newPupilViewModel.getGroupId(),userLogin.getId());
        PupilViewModel pupil = restTemplate.postForEntity(backendServerUrl + "/api/pupils", newPupil, PupilViewModel.class).getBody();
        return pupil;
    }
    
    @Override
    public List<PupilViewModel> getByGroupId(int id) {
    
        RestTemplate restTemplate =new RestTemplate();
        PupilViewModel[] pupilViewModelResponse=
                restTemplate.getForObject(backendServerUrl+"/api/pupils/group/{id}", PupilViewModel[].class, id);
        return pupilViewModelResponse == null? Collections.emptyList(): Arrays.asList(pupilViewModelResponse);
    }
    
    @Override
    public void deletePupil(Long id) {
        RestTemplate restTemplate =new RestTemplate();
        restTemplate.delete(backendServerUrl+"/api/pupils/"+id);
        
    }
}
