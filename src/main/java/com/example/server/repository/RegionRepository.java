package com.example.server.repository;

import com.example.server.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RegionRepository extends JpaRepository<Region, Integer> {
    boolean existsByName(String name);
}
