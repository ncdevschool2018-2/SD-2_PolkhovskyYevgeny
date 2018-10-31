package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.UsersViewModel;
import com.netcracker.edu.fapi.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersDataController {
    
    @Autowired
    private UsersDataService usersDataService;
    
    @RequestMapping
    public ResponseEntity<List<UsersViewModel>> getAllUsers() {
        return ResponseEntity.ok(usersDataService.getAll());
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UsersViewModel> saveUsers(@RequestBody UsersViewModel users /*todo server validation*/) {
        if (users != null) {
            return ResponseEntity.ok(usersDataService.saveUsers(users));
        }
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUsers(@PathVariable String id) {
        usersDataService.deleteUsers(Long.valueOf(id));
    }
}
