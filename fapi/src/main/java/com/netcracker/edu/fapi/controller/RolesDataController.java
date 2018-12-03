package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.RolesViewModel;
import com.netcracker.edu.fapi.service.RolesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RolesDataController {
    @Autowired
    private RolesDataService rolesDataService;
    
    
    @RequestMapping
    public ResponseEntity<List<RolesViewModel>> getAllRoles() {
        return ResponseEntity.ok(rolesDataService.getAll());
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RolesViewModel> saveRoles(@RequestBody RolesViewModel roles /*todo server validation*/) {
        if (roles != null) {
            return ResponseEntity.ok(rolesDataService.saveRoles(roles));
        }
        return null;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRoles(@PathVariable String id) {
        rolesDataService.deleteRoles(Integer.valueOf(id));
    }
}
