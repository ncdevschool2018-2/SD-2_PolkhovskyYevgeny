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
    
    void deletePupil(int id);
    
    PupilViewModel findByUserId(int userId);
}
