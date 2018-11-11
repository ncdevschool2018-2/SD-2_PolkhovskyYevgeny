package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Pupils;
import com.netcracker.edu.backend.service.PupilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pupils")
public class PupilsController {
    
    private PupilsService pupilsService;
    
    @Autowired
    public PupilsController(PupilsService pupilsService) {
        this.pupilsService = pupilsService;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pupils> getPupilId(@PathVariable(name = "id") Long id) {
        Optional<Pupils> pupils = pupilsService.getPupilById(id);
        if (pupils.isPresent()) {
            return ResponseEntity.ok(pupils.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Pupils> getAllPupils() {
        return pupilsService.getAllPupils();
    }
    
    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Pupils>> getAllPupils(@PathVariable(name = "id") int id) {
        List<Pupils> pupils = pupilsService.getByGroupId(id);
        if (pupils != null && !pupils.isEmpty()) {
            return ResponseEntity.ok(pupils);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Pupils savePupil(@RequestBody Pupils pupils) {
        return pupilsService.savePupil(pupils);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePupil(@PathVariable(name = "id") Long id) {
        pupilsService.deletePupil(id);
        return ResponseEntity.noContent().build();
    }
    
}
