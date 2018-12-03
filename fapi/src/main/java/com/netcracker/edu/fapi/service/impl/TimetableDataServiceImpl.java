package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.TimetableDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
    public TimetableViewModel getTimetableById(int id) {
        return null;
    }
    
    
    @Override
    public List<TimetableViewModel> getTimetableByGroupId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        TimetableViewModel[] timetable = new TimetableViewModel[]{};
        TimetableViewModel[] timetable1 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/1/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable2 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/2/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable3 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/3/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable4 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/4/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable5 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/5/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable6 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/6/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable7 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/7/" + id, TimetableViewModel[].class);
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
    public List<TimetableViewModel> getTimetableByTeacherId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        TimetableViewModel[] timetable = new TimetableViewModel[]{};
        TimetableViewModel[] timetable1 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/1/teacher/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable2 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/2/teacher/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable3 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/3/teacher/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable4 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/4/teacher/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable5 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/5/teacher/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable6 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/6/teacher/" + id, TimetableViewModel[].class);
        TimetableViewModel[] timetable7 = restTemplate.getForObject(backendServerUrl + "/api/timetables/day/7/teacher/" + id, TimetableViewModel[].class);
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
    public List<TimetableExampleViewModel> getTimetableNamedByGroupId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        List<TimetableExampleViewModel> timetableExampleResponse = new ArrayList<TimetableExampleViewModel>();
        
        List<TimetableViewModel> startTimetable = getTimetableByGroupId(id);
        helpGetTimetable(restTemplate, timetableExampleResponse, startTimetable);
        
        return timetableExampleResponse;
    }
    
    
    @Override
    public List<TimetableExampleViewModel> getTimetableNamedByTeacherId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        List<TimetableExampleViewModel> timetableExampleResponse = new ArrayList<TimetableExampleViewModel>();
        List<TimetableViewModel> startTimetable = getTimetableByTeacherId(id);
        helpGetTimetable(restTemplate, timetableExampleResponse, startTimetable);
        
        return timetableExampleResponse;
    }
    
    
    private void helpGetTimetable(RestTemplate restTemplate, List<TimetableExampleViewModel> timetableExampleResponse, List<TimetableViewModel> startTimetable) {
        for (TimetableViewModel timetable : startTimetable) {
            TimetableExampleViewModel timetableExample = new TimetableExampleViewModel();
            UniversityGroupViewModel newGroup = restTemplate.getForObject(backendServerUrl + "/api/universitygroups/" + timetable.getGroupId(), UniversityGroupViewModel.class);
            SlotsViewModel newSlots = restTemplate.getForObject(backendServerUrl + "/api/slots/" + timetable.getSlotId(), SlotsViewModel.class);
            DaysOfWeekViewModel newDaysOfWeek = restTemplate.getForObject(backendServerUrl + "/api/days-of-week/" + timetable.getDayOfWeekId(), DaysOfWeekViewModel.class);
            SubjectTeacherViewModel newSubjectTeacher = restTemplate.getForObject(backendServerUrl + "/api/teacher-subject/" + timetable.getSubjectId(), SubjectTeacherViewModel.class);
            SubjectsViewModel newSubject = restTemplate.getForObject(backendServerUrl + "/api/subjects/" + newSubjectTeacher.getSubjectId(), SubjectsViewModel.class);
            TeacherViewModel newTeacher = restTemplate.getForObject(backendServerUrl + "/api/teachers/" + newSubjectTeacher.getTeacherId(), TeacherViewModel.class);
            timetableExample.setTeacherName(newTeacher.getName());
            timetableExample.setTeacherId(newTeacher.getId());
            timetableExample.setTeacherSurname(newTeacher.getSurname());
            timetableExample.setSubject(newSubject.getSubject());
            timetableExample.setDay(newDaysOfWeek.getName());
            timetableExample.setTime(newSlots.getStartTime() + " - " + newSlots.getEndTime());
            timetableExample.setGroup(newGroup.getName());
            timetableExample.setTimetableId(timetable.getId());
            timetableExampleResponse.add(timetableExample);
        }
    }
    
    
    @Override
    public TimetableViewModel saveTimetable(TimetableViewModel timetable) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/timetables", timetable, TimetableViewModel.class).getBody();
    }
    
    
    @Override
    public void deleteTimetable(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/timetables/" + id);
    }
}
