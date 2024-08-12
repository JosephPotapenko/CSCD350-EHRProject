package com.healthconnect.service;

import com.healthconnect.model.Doctor;
import com.healthconnect.model.UserAccount;
import com.healthconnect.repository.DoctorRepository;
import com.healthconnect.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Transactional
    public void registerDoctor(Doctor doctor, UserAccount userAccount) {
        // Save the user account
        userAccountRepository.save(userAccount);

        // Set the user_id in the doctor entity
        doctor.setUserId(userAccount.getUserId());

        // Save the doctor
        doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll(); // Return all doctors from the repository
    }
}