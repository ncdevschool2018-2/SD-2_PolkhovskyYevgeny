package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SlotsViewModel;
import com.netcracker.edu.fapi.service.SlotsDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SlotsDataServiceImpl implements SlotsDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    
    
    @Override
    public List<SlotsViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        SlotsViewModel[] slotsViewModelResponse =
                restTemplate.getForObject(backendServerUrl + "/api/slots/all", SlotsViewModel[].class);
        return slotsViewModelResponse == null ? Collections.emptyList() : Arrays.asList(slotsViewModelResponse);
    }
    
    
    @Override
    public SlotsViewModel getSlotsById(int id) {
        return null;
    }
    
    
    @Override
    public SlotsViewModel saveSlots(SlotsViewModel slot) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/slots", slot, SlotsViewModel.class).getBody();
    }
    
    
    @Override
    public void deleteSlots(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/slots/" + id);
    }
}
