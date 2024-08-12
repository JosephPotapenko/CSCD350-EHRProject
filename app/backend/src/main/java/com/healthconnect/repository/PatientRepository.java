package com.healthconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.healthconnect.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByUserId(Long userId);
}

