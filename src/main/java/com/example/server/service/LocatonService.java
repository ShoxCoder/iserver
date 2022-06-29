package com.example.server.service;

import com.example.server.entity.Location;
import com.example.server.payload.ApiResponse;
import com.example.server.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LocatonService {
    @Autowired
    LocationRepository locationRepository;

    public void addLocation(Location location) {
        Location addLocation=new Location();

        addLocation.setLongitude(location.getLongitude());
        addLocation.setLatitude(location.getLatitude());

        locationRepository.save(addLocation);


    }

    public ApiResponse getLocationById(Integer id) {


        Optional<Location>  optionalLocation = locationRepository.findById(id);
        if (!optionalLocation.isPresent()) return new ApiResponse("Location not found!");
        Location location = optionalLocation.get();
        return new ApiResponse("id si boyicha olindi",true, location);
    }

    public List<Location> getAllLoctions() {
        return locationRepository.findAll();
    }
}
