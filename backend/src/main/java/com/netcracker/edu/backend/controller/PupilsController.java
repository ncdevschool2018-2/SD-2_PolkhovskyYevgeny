package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.dto.PupilDto;
import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.backend.service.PupilsService;
import com.netcracker.edu.backend.service.businesService.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pupils")
public class PupilsController {
    
    private PupilsService pupilsService;
    private RegistrationService registrationService;
    
    
    @Autowired
    public PupilsController(PupilsService pupilsService, RegistrationService registrationService) {
        this.pupilsService = pupilsService;
        this.registrationService = registrationService;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pupils> getPupilId(@PathVariable(name = "id") int id) {
        Optional<Pupils> pupils = pupilsService.getPupilById(id);
        if (pupils.isPresent()) {
            return ResponseEntity.ok(pupils.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @RequestMapping(value = "/userId/{id}", method = RequestMethod.GET)
    public Pupils getPupilByUserId(@PathVariable(name = "id") int id) {
        Pupils pupils = pupilsService.findByUserId(id);
        return pupils;
    }
    
    
    @RequestMapping(value = "/surname/{surname}/name/{name}/group/{group}", method = RequestMethod.GET)
    public List<Pupils> findPupilByNameAndSurname(@PathVariable(name = "surname") String surname, @PathVariable(name = "name") String name, @PathVariable(name = "group") int group) {
        
        List<Pupils> pupils = pupilsService.findPupilBySurnameAndName(surname, name, group);
        return pupils;
    }
    
    
    @RequestMapping(value = "/surname/{surname}/group/{group}", method = RequestMethod.GET)
    public List<Pupils> findPupilBySurname(@PathVariable(name = "surname") String surname, @PathVariable(name = "group") int group) {
        
        List<Pupils> pupils = pupilsService.findPupilBySurname(surname, group);
        return pupils;
    }
    
    
    @RequestMapping(value = "/name/{name}/group/{group}", method = RequestMethod.GET)
    public List<Pupils> findPupilByName(@PathVariable(name = "name") String name, @PathVariable(name = "group") int group) {
        
        List<Pupils> pupils = pupilsService.findPupilByName(name, group);
        return pupils;
    }
    
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Pupils> getAllPupils() {
        return pupilsService.getAllPupils();
    }
    
    
    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Pupils>> getAllPupils(@PathVariable(name = "id") int id) {
        List<Pupils> pupils = pupilsService.getByGroupIdOrderBySurname(id);
        if (pupils != null) {
            return ResponseEntity.ok(pupils);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public Pupils registratePupil(@RequestBody PupilDto pupilDto) {
        return registrationService.registratePupil(pupilDto);
        //return pupilsService.savePupil(pupils);
    }
    
    
    @RequestMapping(value = "/edit-pupil", method = RequestMethod.POST)
    public Pupils editPupil(@RequestBody Pupils pupils) {
        return registrationService.editPupil(pupils);
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePupil(@PathVariable(name = "id") int id) {
        pupilsService.deletePupil(id);
        return ResponseEntity.noContent().build();
    }
    
}
