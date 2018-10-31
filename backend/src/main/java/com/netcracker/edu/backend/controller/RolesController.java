package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Roles;
import com.netcracker.edu.backend.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
    private RolesService rolesService;
    
    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Roles> getRolesById(@PathVariable(name = "id") Long id) {
        Optional<Roles> roles = rolesService.getRolesById(id);
        if (roles.isPresent()) {
            return ResponseEntity.ok(roles.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Roles> getAllRoles() {
        return rolesService.getAllRoles();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Roles saveRoles(@RequestBody Roles role) {
        return rolesService.saveRoles(role);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteRoles(@PathVariable(name = "id") Long id) {
        rolesService.deleteRoles(id);
        return ResponseEntity.noContent().build();
    }
}
