package com.healthconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.healthconnect.model.Patient;
import com.healthconnect.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patientDetails) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setFirstName(patientDetails.getFirstName());
            patient.setLastName(patientDetails.getLastName());
            patient.setDob(patientDetails.getDob());
            patient.setGender(patientDetails.getGender());
            patient.setPhoneNumber(patientDetails.getPhoneNumber());
            patient.setEmail(patientDetails.getEmail());
            return patientRepository.save(patient);
        } else {
            throw new RuntimeException("Patient not found with id " + id);
        }
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
