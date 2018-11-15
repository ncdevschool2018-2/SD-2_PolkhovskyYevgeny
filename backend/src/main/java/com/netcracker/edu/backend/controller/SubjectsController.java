package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Subjects;
import com.netcracker.edu.backend.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/subjects")
public class SubjectsController {
    private SubjectsService subjectsService;
    
    @Autowired
    public SubjectsController(SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Subjects> getSubjectsById(@PathVariable(name = "id") int id) {
        Optional<Subjects> subjects = subjectsService.getSubjectsById(id);
        if (subjects.isPresent()) {
            return ResponseEntity.ok(subjects.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Subjects> getAllSubjects() {
        return subjectsService.getAllSubjects();
    }
    
    @RequestMapping(value = "/dist", method = RequestMethod.GET)
    public ResponseEntity<List<Subjects>> getDistinctSubject() {
        List<Subjects> subjects = subjectsService.getDistinctSubject();
        if(subjects!=null && !subjects.isEmpty()){
            return ResponseEntity.ok(subjects);
        }else {
            return ResponseEntity.notFound().build();
    
        }
    }
    @RequestMapping(value = "/choose/{sub}", method = RequestMethod.GET)
    public ResponseEntity<List<Subjects>> getAllBySubject(@PathVariable(name = "sub") String sub) {
        List<Subjects> subjects = subjectsService.getAllBySubject(sub);
    
    
        if(subjects!=null && !subjects.isEmpty()){
            return ResponseEntity.ok(subjects);
        }else {
            return ResponseEntity.notFound().build();
        
        }
    }
   /* @RequestMapping(value = "/chooseId/{sub}", method = RequestMethod.GET)
    public ResponseEntity<Integer[]> getIdChoosenSubject(@PathVariable(name = "sub") String sub) {
        Integer[] subjects = subjectsService.getIdChoosenSubject(sub);
    
    
        if(subjects!=null ){
            return ResponseEntity.ok(subjects);
        }else {
            return ResponseEntity.notFound().build();
        
        }
    }*/
    
    
    @RequestMapping(method = RequestMethod.POST)
    public Subjects saveSubjects(@RequestBody Subjects subjects) {
        return subjectsService.saveSubjects(subjects);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteSubjects(@PathVariable(name = "id") int id) {
        subjectsService.deleteSubjects(id);
        return ResponseEntity.noContent().build();
    }
}
