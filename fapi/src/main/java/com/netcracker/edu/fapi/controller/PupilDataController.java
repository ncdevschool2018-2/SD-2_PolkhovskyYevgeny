package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.NewUserViewModel;
import com.netcracker.edu.fapi.models.PupilViewModel;
import com.netcracker.edu.fapi.models.UsersViewModel;
import com.netcracker.edu.fapi.service.PupilDataService;
import com.netcracker.edu.fapi.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private UsersDataService usersDataService;
    
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
    
    
    @RequestMapping(value = "/surname/{surname}/name/{name}/group/{group}")
    public ResponseEntity<List<PupilViewModel>> findPupilBySurnameAndName(@PathVariable String surname, @PathVariable String name, @PathVariable int group) {
        return ResponseEntity.ok(pupilDataService.findPupilBySurnameAndName(surname, name, group));
    }
    
    
    @RequestMapping(value = "/surname/{surname}/group/{group}")
    public ResponseEntity<List<PupilViewModel>> findPupilBySurname(@PathVariable String surname,  @PathVariable int group) {
        return ResponseEntity.ok(pupilDataService.findPupilBySurname(surname,  group));
    }
    
    
    @RequestMapping(value = "/name/{name}/group/{group}")
    public ResponseEntity<List<PupilViewModel>> findPupilByName( @PathVariable String name, @PathVariable int group) {
        return ResponseEntity.ok(pupilDataService.findPupilByName( name, group));
    }
    
    
    @RequestMapping(value = "/userId/{id}")
    public ResponseEntity<PupilViewModel> findByUserId(@PathVariable int id) {
        return ResponseEntity.ok(pupilDataService.findByUserId(id));
    }
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/new-pupil")
    public ResponseEntity<PupilViewModel> savePupil(@RequestBody NewUserViewModel pupil /*todo server validation*/) {
        List<UsersViewModel> usersViewModels = usersDataService.getAll();
        for (UsersViewModel user : usersViewModels
        ) {if(user.getLogin().equals(pupil.getLogin())){
            //return new ResponseEntity("bad",HttpStatus.BAD_REQUEST);
            return  null;
        }}
        if (pupil.getName().matches("[a-zA-Z]{3,10}") &&
                pupil.getSurname().matches("[a-zA-Z]{3,10}") &&
                pupil.getLogin().matches("[a-zA-Z0-9]{3,10}") &&
                pupil.getPassword().matches("[a-zA-Z0-9]{3,10}")) {
            NewUserViewModel newPupil =
                    new NewUserViewModel(pupil.getName(), pupil.getSurname(), pupil.getSubjectId(), pupil.getGroupId(), pupil.getUserId(), pupil.getLogin(), bcryptEncoder.encode(pupil.getPassword()), pupil.getRoleId());
            if (newPupil != null) {
                return ResponseEntity.ok(pupilDataService.savePupil(newPupil));
            }
            return null;
        } else {
            return null;
        }
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PupilViewModel> saveEditPupil(@RequestBody PupilViewModel pupil /*todo server validation*/) {
        if (pupil.getName().matches("[a-zA-Z]{3,10}") &&
                pupil.getSurname().matches("[a-zA-Z]{3,10}")) {
            if (pupil != null) {
                return ResponseEntity.ok(pupilDataService.saveEditPupil(pupil));
            }
            return null;
        } else {
            return null;
        }
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePupil(@PathVariable String id) {
        pupilDataService.deletePupil(Integer.valueOf(id));
    }
}
