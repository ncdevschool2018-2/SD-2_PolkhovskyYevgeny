package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.NewPupilViewModel;
import com.netcracker.edu.fapi.models.NewUserViewModel;
import com.netcracker.edu.fapi.models.PupilViewModel;
import com.netcracker.edu.fapi.models.UsersViewModel;
import com.netcracker.edu.fapi.service.PupilDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PupilDataServiceImpl implements PupilDataService {
    
    UsersDataServiceImpl usersDataService;
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    @Autowired
    public PupilDataServiceImpl(UsersDataServiceImpl usersDataService) {
        this.usersDataService = usersDataService;
    }
    
    @Override
    public List<PupilViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        PupilViewModel[] pupilViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/pupils/all", PupilViewModel[].class);
        return pupilViewModelResponse == null ? Collections.emptyList() : Arrays.asList(pupilViewModelResponse);
    }
    
    
    @Override
    public PupilViewModel getPupilById(int id) {
        
        return null;
    }
    
    
    @Override
    public PupilViewModel savePupil(NewUserViewModel newPupilViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        NewPupilViewModel newPupil = new NewPupilViewModel(newPupilViewModel.getName(), newPupilViewModel.getSurname(), newPupilViewModel.getGroupId(), newPupilViewModel.getUserId(), newPupilViewModel.getLogin(), newPupilViewModel.getPassword(), newPupilViewModel.getRoleId());
        List<UsersViewModel> usersViewModels = usersDataService.getAll();
        for (UsersViewModel user : usersViewModels
        ) {if(user.getLogin().equals(newPupilViewModel.getLogin())){
            return null;
        }}
        NewPupilViewModel pupil = restTemplate.postForEntity(backendServerUrl + "/api/pupils", newPupil, NewPupilViewModel.class).getBody();
        
        
        return new PupilViewModel();
    }
    
    
    
    @Override
    public PupilViewModel saveEditPupil(PupilViewModel pupil) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/pupils/edit-pupil", pupil, PupilViewModel.class).getBody();
    }
    
    
    @Override
    public List<PupilViewModel> getByGroupId(int id) {
        
        RestTemplate restTemplate = new RestTemplate();
        PupilViewModel[] pupilViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/pupils/group/{id}", PupilViewModel[].class, id);
        return pupilViewModelResponse == null ? Collections.emptyList() : Arrays.asList(pupilViewModelResponse);
    }
    
    
    @Override
    public List<PupilViewModel> findPupilBySurnameAndName(String surname, String name, int groupId) {
        RestTemplate restTemplate = new RestTemplate();
        PupilViewModel[] pupilViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/pupils/surname/"+surname+"/name/"+name+"/group/"+groupId, PupilViewModel[].class);
        return pupilViewModelResponse == null ? Collections.emptyList() : Arrays.asList(pupilViewModelResponse);
    }
    
    
    @Override
    public List<PupilViewModel> findPupilBySurname(String surname, int groupId) {
        RestTemplate restTemplate = new RestTemplate();
        PupilViewModel[] pupilViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/pupils/surname/"+surname+"/group/"+groupId, PupilViewModel[].class);
        return pupilViewModelResponse == null ? Collections.emptyList() : Arrays.asList(pupilViewModelResponse);
    
    }
    
    
    @Override
    public List<PupilViewModel> findPupilByName(String name, int groupId) {
        RestTemplate restTemplate = new RestTemplate();
        PupilViewModel[] pupilViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/pupils/name/"+name+"/group/"+groupId, PupilViewModel[].class);
        return pupilViewModelResponse == null ? Collections.emptyList() : Arrays.asList(pupilViewModelResponse);
    
    }
    
    
    @Override
    public void deletePupil(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/pupils/" + id);
        
    }
    
    
    @Override
    public PupilViewModel findByUserId(int userId) {
        RestTemplate restTemplate = new RestTemplate();
        PupilViewModel pupilViewModelResponse =
                restTemplate.getForObject(backendServerUrl+"/api/pupils/userId/"+userId,PupilViewModel.class);
        
        return pupilViewModelResponse;
    }
}
