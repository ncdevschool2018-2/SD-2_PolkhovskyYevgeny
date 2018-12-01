package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.NewUserViewModel;
import com.netcracker.edu.fapi.models.PupilViewModel;
import com.netcracker.edu.fapi.service.PupilDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pupil")
public class PupilDataController {
    
    @Autowired
    private PupilDataService pupilDataService;
    
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;
    
    @RequestMapping
    public ResponseEntity<List<PupilViewModel>> getAllPupils() {
        return ResponseEntity.ok(pupilDataService.getAll());
    }
    
    @RequestMapping(value = "/group/{id}")
    public ResponseEntity<List<PupilViewModel>> getByGroupId(@PathVariable int id) {
        return ResponseEntity.ok(pupilDataService.getByGroupId(id));
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/new-pupil")
    public ResponseEntity<PupilViewModel> savePupil(@RequestBody NewUserViewModel pupil /*todo server validation*/) {
        NewUserViewModel newPupil= new NewUserViewModel(pupil.getName(),pupil.getSurname(),pupil.getSubjectId(),pupil.getGroupId(),pupil.getUserId(),pupil.getLogin(),bcryptEncoder.encode(pupil.getPassword()),pupil.getRoleId());
        if (newPupil != null) {
            return ResponseEntity.ok(pupilDataService.savePupil(newPupil));
        }
        return null;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PupilViewModel> saveEditPupil(@RequestBody PupilViewModel pupil /*todo server validation*/) {
        if (pupil != null) {
            return ResponseEntity.ok(pupilDataService.saveEditPupil(pupil));
        }
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePupil(@PathVariable String id) {
        pupilDataService.deletePupil(Integer.valueOf(id));
    }
}
