package com.example.server.controller;

import com.example.server.entity.Hospital;
import com.example.server.payload.ApiResponse;
import com.example.server.payload.HospitalDto;
import com.example.server.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/hospital")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @GetMapping("/all")
    public HttpEntity<?> getAllHospitals(){
        List<Hospital> allHospitals = hospitalService.getAllHospitals();
        return ResponseEntity.ok(allHospitals);
    }

    @PostMapping
    public HttpEntity<?> addHospital(@RequestBody HospitalDto hospitalDto){
        ApiResponse apiResponse = hospitalService.addHospital(hospitalDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editHospital(@RequestBody HospitalDto hospitalDto, @PathVariable Integer id){
        ApiResponse apiResponse = hospitalService.updateHospital(hospitalDto, id);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getHospitalById(@PathVariable Integer id){
        ApiResponse hospitalById = hospitalService.getHospitalById(id);
        return ResponseEntity.ok(hospitalById);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteHospitalById(@PathVariable Integer id){
        ApiResponse apiResponse = hospitalService.deleteHospital(id);
        return ResponseEntity.ok(apiResponse);
    }
}
