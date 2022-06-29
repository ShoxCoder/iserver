package com.example.server.repository;

import com.example.server.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
    boolean existsByName(String name);

}
