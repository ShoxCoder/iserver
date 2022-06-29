package com.example.server.repository;

import com.example.server.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    boolean existsByName(String name);
}
