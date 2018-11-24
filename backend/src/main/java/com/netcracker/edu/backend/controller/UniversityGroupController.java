package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UniversityGroup;
import com.netcracker.edu.backend.service.UniversityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/universitygroups")
public class UniversityGroupController {
    private UniversityGroupService universityGroupService;
    
    @Autowired
    public UniversityGroupController(UniversityGroupService universityGroupService) {
        this.universityGroupService = universityGroupService;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UniversityGroup> getUniversityGroupById(@PathVariable(name = "id") int id) {
        Optional<UniversityGroup> universityGroup = universityGroupService.getUniversityGroupById(id);
        if (universityGroup.isPresent()) {
            return ResponseEntity.ok(universityGroup.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<UniversityGroup> getAllOrderUniversityGroup() {
        return universityGroupService.getAllOrderUniversityGroup();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public UniversityGroup saveUniversityGroup(@RequestBody UniversityGroup universityGroup) {
        return universityGroupService.saveUniversityGroup(universityGroup);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUniversityGroup(@PathVariable(name = "id") int id) {
        universityGroupService.deleteUniversityGroup(id);
        return ResponseEntity.noContent().build();
    }
}
