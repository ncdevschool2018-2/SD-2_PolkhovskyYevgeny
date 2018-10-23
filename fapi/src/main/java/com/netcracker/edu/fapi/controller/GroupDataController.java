package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.GroupViewModel;
import com.netcracker.edu.fapi.service.GroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupDataController {
    
    @Autowired
    private GroupDataService groupDataService;
    
    @RequestMapping
    public ResponseEntity<List<GroupViewModel>> getAllGroups(){
        return ResponseEntity.ok(groupDataService.getAll());
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<GroupViewModel> saveGroup(@RequestBody GroupViewModel group /*todo server validation*/){
        if(group !=null){
            return ResponseEntity.ok(groupDataService.saveGroup(group));
        }
        return null;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteGroup(@PathVariable String id) {
        groupDataService.deleteGroup(Long.valueOf(id));
    }
}
