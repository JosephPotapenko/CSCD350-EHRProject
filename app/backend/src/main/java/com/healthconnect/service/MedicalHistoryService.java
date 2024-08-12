package com.healthconnect.service;

import com.healthconnect.model.MedicalHistory;
import com.healthconnect.model.Patient;
import com.healthconnect.repository.MedicalHistoryRepository;
import com.healthconnect.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MedicalHistoryService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    public List<MedicalHistory> getMedicalHistoryForUser(Long userId) {
        Patient patient = patientRepository.findByUserId(userId);
        if (patient != null) {
            return medicalHistoryRepository.findByPatientId(patient.getPatientId());
        }
        return Collections.emptyList();
    }
}
