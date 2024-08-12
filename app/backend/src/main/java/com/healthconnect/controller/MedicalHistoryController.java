package com.healthconnect.controller;

import com.healthconnect.model.MedicalHistory;
import com.healthconnect.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-history")
public class MedicalHistoryController {
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @GetMapping
    public ResponseEntity<List<MedicalHistory>> getMedicalHistory(@RequestParam Long userId) {
        List<MedicalHistory> history = medicalHistoryService.getMedicalHistoryForUser(userId);
        return ResponseEntity.ok(history);
    }
}
