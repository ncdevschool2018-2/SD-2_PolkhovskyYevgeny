package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Slots;
import com.netcracker.edu.backend.service.SlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/slots")
public class SlotsController {
    private SlotsService slotsService;
    
    @Autowired
    public SlotsController(SlotsService slotsService) {
        this.slotsService = slotsService;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Slots> getSlotsById(@PathVariable(name = "id") int id) {
        Optional<Slots> slots = slotsService.getSlotsById(id);
        if (slots.isPresent()) {
            return ResponseEntity.ok(slots.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Slots> getAllSlots() {
        return slotsService.getAllSlots();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Slots saveSlots(@RequestBody Slots slots) {
        return slotsService.saveSlots(slots);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteSlots(@PathVariable(name = "id") int id) {
        slotsService.deleteSlots(id);
        return ResponseEntity.noContent().build();
    }
}
