package com.example.server.repository;


import com.example.server.entity.IllnessInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessInfoRepository extends JpaRepository<IllnessInfo,Integer> {


    boolean existsByIllnessName(String illnessName);
}
