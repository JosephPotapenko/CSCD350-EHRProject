package com.healthconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.healthconnect.model.Nurse;
import com.healthconnect.service.NurseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nurses")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @GetMapping
    public List<Nurse> getAllNurses() {
        return nurseService.getAllNurses();
    }

    @GetMapping("/{id}")
    public Optional<Nurse> getNurseById(@PathVariable Long id) {
        return nurseService.getNurseById(id);
    }

    @PostMapping
    public Nurse createNurse(@RequestBody Nurse nurse) {
        return nurseService.addNurse(nurse);
    }

    @PutMapping("/{id}")
    public Nurse updateNurse(@PathVariable Long id, @RequestBody Nurse nurseDetails) {
        return nurseService.updateNurse(id, nurseDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteNurse(@PathVariable Long id) {
        nurseService.deleteNurse(id);
    }
}
