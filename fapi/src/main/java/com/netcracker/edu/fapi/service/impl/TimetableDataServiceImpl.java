package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.TimetableViewModel;
import com.netcracker.edu.fapi.service.TimetableDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TimetableDataServiceImpl implements TimetableDataService {
    
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    @Override
    public List<TimetableViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        TimetableViewModel[] timetableViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/timetables/all", TimetableViewModel[].class);
        return timetableViewModelResponse == null ? Collections.emptyList() : Arrays.asList(timetableViewModelResponse);
    }
    
    @Override
    public TimetableViewModel getTimetableById(Long id) {
        return null;
    }
    
    @Override
    public TimetableViewModel saveTimetable(TimetableViewModel timetable) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/timetables", timetable, TimetableViewModel.class).getBody();
    }
    
    @Override
    public void deleteTimetable(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/timetables/" + id);
    }
}
