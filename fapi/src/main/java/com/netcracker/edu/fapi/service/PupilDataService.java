package com.netcracker.edu.fapi.service;

import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.fapi.models.NewUserViewModel;
import com.netcracker.edu.fapi.models.PupilViewModel;

import java.util.List;
import java.util.Optional;

public interface PupilDataService {
    List<PupilViewModel> getAll();
    PupilViewModel getPupilById(Long id);
    PupilViewModel savePupil(NewUserViewModel pupil);
    PupilViewModel saveEditPupil(PupilViewModel pupil);
    List<PupilViewModel> getByGroupId(int id);
    void deletePupil(Long id);
}
