package com.example.server.service;

import com.example.server.entity.Hospital;
import com.example.server.entity.Location;
import com.example.server.entity.Region;
import com.example.server.payload.ApiResponse;
import com.example.server.payload.HospitalDto;
import com.example.server.repository.HospitalRepository;
import com.example.server.repository.LocationRepository;
import com.example.server.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

// Nurkulov Nodirbek 5/19/2022  5:09 AM
@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final LocationRepository locationRepository;
    private final RegionRepository regionRepository;

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public ApiResponse addHospital(HospitalDto hospitalDto) {
         Hospital hospital=new Hospital();
        if (!hospitalRepository.existsByName(hospitalDto.getName())){
            Optional<Location> optionalLocation = locationRepository.findById(hospitalDto.getLocationId());
            Optional<Region> optionalRegion = regionRepository.findById(hospitalDto.getRegionId());
            hospital.setName(hospitalDto.getName());
            hospital.setRegion(optionalRegion.get());
            hospital.setLocation(optionalLocation.get());

            hospitalRepository.save(hospital);
            return new ApiResponse("Saved",true);

        }
        return new ApiResponse("This hospital allready defined",false);


    }

    public ApiResponse updateHospital(HospitalDto hospitalDto, Integer id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if (!optionalHospital.isPresent()) return new ApiResponse("Hospital not found!!!");
        Optional<Location> optionalLocation = locationRepository.findById(hospitalDto.getLocationId());
        Optional<Region> optionalRegion = regionRepository.findById(hospitalDto.getRegionId());
        Hospital editHospital =new Hospital();
        editHospital.setName(hospitalDto.getName());
        editHospital.setLocation(optionalLocation.get());
        editHospital.setRegion(optionalRegion.get());
        hospitalRepository.save(editHospital);

        return new ApiResponse("Hospital edited!", true);
    }


    public ApiResponse getHospitalById(Integer id) {

        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if (!optionalHospital.isPresent()) return new ApiResponse("Hospital not found!");
        Hospital hospital = optionalHospital.get();
        return new ApiResponse("id si boyicha olindi",true, hospital);
    }

    public ApiResponse deleteHospital(Integer id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if (!optionalHospital.isPresent()) return new ApiResponse("Hospital not found!", false);
        hospitalRepository.deleteById(id);
            return new ApiResponse("Hospital deleted!", true);

    }
}
