package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.TimetableViewModel;
import com.netcracker.edu.fapi.service.TimetableDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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
    public List<TimetableViewModel> getTimetableByGroupId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        TimetableViewModel[] timetable = new TimetableViewModel[]{};
        TimetableViewModel[] timetable1 = restTemplate.getForObject(backendServerUrl + "/api/timetables/pupil/1/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable2 = restTemplate.getForObject(backendServerUrl + "/api/timetables/pupil/2/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable3 = restTemplate.getForObject(backendServerUrl + "/api/timetables/pupil/3/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable4 = restTemplate.getForObject(backendServerUrl + "/api/timetables/pupil/4/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable5 = restTemplate.getForObject(backendServerUrl + "/api/timetables/pupil/5/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable6 = restTemplate.getForObject(backendServerUrl + "/api/timetables/pupil/6/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable7 = restTemplate.getForObject(backendServerUrl + "/api/timetables/pupil/7/" + id, TimetableViewModel[].class);
        if (timetable1 != null) {
            timetable = Stream.concat(Arrays.stream(timetable), Arrays.stream(timetable1)).toArray(TimetableViewModel[]::new);
        }
        if (timetable2 != null) {
            timetable = Stream.concat(Arrays.stream(timetable), Arrays.stream(timetable2)).toArray(TimetableViewModel[]::new);
        }
        if (timetable3 != null) {
            timetable = Stream.concat(Arrays.stream(timetable), Arrays.stream(timetable3)).toArray(TimetableViewModel[]::new);
        }
        if (timetable4 != null) {
            timetable = Stream.concat(Arrays.stream(timetable), Arrays.stream(timetable4)).toArray(TimetableViewModel[]::new);
        }
        if (timetable5 != null) {
            timetable = Stream.concat(Arrays.stream(timetable), Arrays.stream(timetable5)).toArray(TimetableViewModel[]::new);
        }
        if (timetable6 != null) {
            timetable = Stream.concat(Arrays.stream(timetable), Arrays.stream(timetable6)).toArray(TimetableViewModel[]::new);
        }
        if (timetable7 != null) {
            timetable = Stream.concat(Arrays.stream(timetable), Arrays.stream(timetable7)).toArray(TimetableViewModel[]::new);
        }
        
        return timetable == null ? Collections.emptyList() : Arrays.asList(timetable);
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
