package com.healthconnect.repository;

import com.healthconnect.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUserAccountUsername(String username);
}
