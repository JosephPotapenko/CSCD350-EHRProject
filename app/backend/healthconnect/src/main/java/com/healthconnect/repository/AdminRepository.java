package com.healthconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.healthconnect.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
