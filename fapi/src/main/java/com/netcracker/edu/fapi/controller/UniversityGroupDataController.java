package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.UniversityGroupViewModel;
import com.netcracker.edu.fapi.service.UniversityGroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universitygroup")
public class UniversityGroupDataController {
    
    @Autowired
    private UniversityGroupDataService universityGroupDataService;
    
    @RequestMapping
    public ResponseEntity<List<UniversityGroupViewModel>> getAllUniversityGroup(){
        return ResponseEntity.ok(universityGroupDataService.getAll());
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UniversityGroupViewModel> saveUniversityGroup(@RequestBody UniversityGroupViewModel group /*todo server validation*/){
        if(group !=null){
            return ResponseEntity.ok(universityGroupDataService.saveUniversityGroup(group));
        }
        return null;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUniversityGroup(@PathVariable String id) {
        universityGroupDataService.deleteUniversityGroup(Integer.valueOf(id));
    }
}
