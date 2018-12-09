package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.UsersViewModel;
import com.netcracker.edu.fapi.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public UsersViewModel saveUser(@RequestBody UsersViewModel user) {
        return usersDataService.saveUsers(user);
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUsers(@PathVariable String id) {
        usersDataService.deleteUsers(Integer.valueOf(id));
    }
    
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsersViewModel> getUserById(@PathVariable(name = "id") int id) {
        Optional<UsersViewModel> user = usersDataService.getUsersById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    //@PreAuthorize("hasAnyAuthority('1','2','3')")
    @RequestMapping(value = "userLogin/", method = RequestMethod.GET)
    public ResponseEntity<UsersViewModel> getUser() {
        UsersViewModel currentUser = usersDataService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if (currentUser != null) {
            return ResponseEntity.ok(currentUser);
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }
    
    
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ResponseEntity<UsersViewModel> getAccountByLogin(@RequestParam(name = "login") String login) {
        UsersViewModel account = usersDataService.findByLogin(login);
        return ResponseEntity.ok(account);
    }
    
}
