package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.DaysOfWeekViewModel;
import com.netcracker.edu.fapi.service.DaysOfWeekDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DaysOfWeekDataServiceImpl implements DaysOfWeekDataService {
    
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    @Override
    public List<DaysOfWeekViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        DaysOfWeekViewModel[] daysOfWeekViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/days-of-week/all", DaysOfWeekViewModel[].class);
        return daysOfWeekViewModelResponse == null ? Collections.emptyList() : Arrays.asList(daysOfWeekViewModelResponse);
    }
    
    @Override
    public DaysOfWeekViewModel getDaysOfWeekById(int id) {
        return null;
    }
    
    @Override
    public DaysOfWeekViewModel saveDaysOfWeek(DaysOfWeekViewModel day) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/days-of-week", day, DaysOfWeekViewModel.class).getBody();
    }
    
    @Override
    public void deleteDaysOfWeek(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/days-of-week/" + id);
        
    }
}
