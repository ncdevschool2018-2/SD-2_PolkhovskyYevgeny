package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.UniversityGroupViewModel;
import com.netcracker.edu.fapi.service.UniversityGroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/universitygroup")
public class UniversityGroupDataController {
    
    @Autowired
    private UniversityGroupDataService universityGroupDataService;
    
    
    @RequestMapping
    public ResponseEntity<List<UniversityGroupViewModel>> getAllUniversityGroup() {
        return ResponseEntity.ok(universityGroupDataService.getAll());
    }
    
    
    @PreAuthorize("hasAnyAuthority('1')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UniversityGroupViewModel> saveUniversityGroup(@RequestBody UniversityGroupViewModel group /*todo server validation*/) {
        if (group != null && Integer.parseInt(group.getName()) >= 1000000 && Integer.parseInt(group.getName()) <= 99999999) {
            List<UniversityGroupViewModel> groups;
            groups = universityGroupDataService.getAll();
            for (UniversityGroupViewModel groupn : groups
            ) {
                if(groupn.getName().equals(group.getName())){
                    return null;
                }
                
            }
            return ResponseEntity.ok(universityGroupDataService.saveUniversityGroup(group));
        }
        return null;
    }
    
    
    /*@RequestMapping(value = "/page",method = RequestMethod.POST)
    public ResponseEntity<PageGroupViewModel> getGroupPage(@RequestBody int page){
        
        return ResponseEntity.ok(universityGroupDataService.getPageGroup(page));
        
    }*/
    @RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
    public ResponseEntity<List<UniversityGroupViewModel>> getGroupPage(@PathVariable int page) {
        
        return ResponseEntity.ok(universityGroupDataService.findGroupPage(page));
        
    }
    
    
    @RequestMapping(value = "/search/{word}", method = RequestMethod.GET)
    public ResponseEntity<List<UniversityGroupViewModel>> findGroup(@PathVariable String word) {
        
        return ResponseEntity.ok(universityGroupDataService.findGroup(word));
        
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UniversityGroupViewModel> getUniversityGroupById(@PathVariable int id) {
        
        return ResponseEntity.ok(universityGroupDataService.getUniversityGroupById(id));
        
    }
    
    
    @RequestMapping(value = "/totalPages", method = RequestMethod.GET)
    public ResponseEntity<Integer> getTotalPages() {
        return ResponseEntity.ok(universityGroupDataService.getTotalPages());
    }
    
    
    @PreAuthorize("hasAnyAuthority('1')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUniversityGroup(@PathVariable String id) {
        universityGroupDataService.deleteUniversityGroup(Integer.valueOf(id));
    }
}
