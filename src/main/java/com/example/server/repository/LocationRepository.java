package com.example.server.repository;

import com.example.server.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location,Integer> {
}
