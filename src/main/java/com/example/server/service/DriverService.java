package com.example.server.service;

import com.example.server.entity.Driver;
import com.example.server.entity.Hospital;
import com.example.server.payload.ApiResponse;
import com.example.server.payload.DriverDto;
import com.example.server.repository.DriverRepository;
import com.example.server.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service

public class DriverService {
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    HospitalRepository hospitalRepository;

    public List<Driver> getAllDrivers() {

        return driverRepository.findAll();
    }

    public ApiResponse addDriver(DriverDto driverDto) {
        if (!driverRepository.existsByName(driverDto.getName())){
            Driver driver= new Driver();
            Optional<Hospital> byId = hospitalRepository.findById(driverDto.getHospitalId());
            driver.setName(driverDto.getName());
            driver.setHospital(byId.get());
            driverRepository.save(driver);
            return new ApiResponse("sucsessfully added",true);
        }
        return new ApiResponse("this name already defined",false);
    }

    public ApiResponse getOne(Integer id) {
        Optional<Driver> byId = driverRepository.findById(id);
        if(!byId.isPresent()){
            return new ApiResponse("This kind of driver is not found",false);
        }
        Driver driver=byId.get();
        return new ApiResponse("found",true,driver);
    }

    public ApiResponse edit(Integer id, DriverDto driverDto) {

        Optional<Driver> byId = driverRepository.findById(id);
        if (byId.isPresent()){
            Driver editDriver=new Driver();
            Optional<Hospital> optionalHospital = hospitalRepository.findById(driverDto.getHospitalId());
            editDriver.setHospital(optionalHospital.get());
            editDriver.setName(driverDto.getName());

            driverRepository.save(editDriver);

            return new ApiResponse("Changed",true);

        }
        return new ApiResponse("Not Found",false);

    }


    public ApiResponse delete(Integer id) {
        Optional<Driver> byId = driverRepository.findById(id);
        if (!byId.isPresent()){
            return new ApiResponse("not found",false);
        }
        driverRepository.deleteById(id);
        return new ApiResponse("deleted",true);
    }
}
