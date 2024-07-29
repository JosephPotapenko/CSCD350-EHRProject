package com.healthconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.healthconnect.model.Nurse;
import com.healthconnect.repository.NurseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    public Optional<Nurse> getNurseById(Long id) {
        return nurseRepository.findById(id);
    }

    public Nurse addNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public Nurse updateNurse(Long id, Nurse nurseDetails) {
        Optional<Nurse> optionalNurse = nurseRepository.findById(id);
        if (optionalNurse.isPresent()) {
            Nurse nurse = optionalNurse.get();
            nurse.setUsername(nurseDetails.getUsername());
            nurse.setPassword(nurseDetails.getPassword());
            nurse.setFirstName(nurseDetails.getFirstName());
            nurse.setLastName(nurseDetails.getLastName());
            nurse.setContactInfo(nurseDetails.getContactInfo());
            nurse.setEmail(nurseDetails.getEmail());
            return nurseRepository.save(nurse);
        } else {
            throw new RuntimeException("Nurse not found with id " + id);
        }
    }

    public void deleteNurse(Long id) {
        nurseRepository.deleteById(id);
    }
}
