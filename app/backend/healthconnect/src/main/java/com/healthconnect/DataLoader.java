/*package com.healthconnect;

import com.healthconnect.model.Doctor;
import com.healthconnect.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Running DataLoader...");

        Doctor doctor = new Doctor();
        doctor.setFirstName("bill");
        doctor.setLastName("Johnson");
        doctor.setSpecialty("Gynecologist");
        doctor.setContactInfo("509-867-5309");
        doctor.setEmail("john1@ewu.com");

        doctorRepository.save(doctor);
        logger.info("Doctor saved: " + doctor);
    }
}*/
