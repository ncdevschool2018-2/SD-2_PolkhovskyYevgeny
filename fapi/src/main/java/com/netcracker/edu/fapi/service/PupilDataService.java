package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.NewUserViewModel;
import com.netcracker.edu.fapi.models.PupilViewModel;

import java.util.List;

public interface PupilDataService {
    List<PupilViewModel> getAll();
    
    PupilViewModel getPupilById(int id);
    
    PupilViewModel savePupil(NewUserViewModel pupil);
    
    PupilViewModel saveEditPupil(PupilViewModel pupil);
    
    List<PupilViewModel> getByGroupId(int id);
    
    List<PupilViewModel> findPupilBySurnameAndName(String surname, String name, int groupId);
    
    List<PupilViewModel> findPupilBySurname(String surname, int groupId);
    
    List<PupilViewModel> findPupilByName( String name, int groupId);
    
    void deletePupil(int id);
    
    PupilViewModel findByUserId(int userId);
}
