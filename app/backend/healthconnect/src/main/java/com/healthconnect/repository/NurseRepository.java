package com.healthconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.healthconnect.model.Nurse;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
