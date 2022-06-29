package com.example.server.controller;

import com.example.server.entity.Location;
import com.example.server.payload.ApiResponse;
import com.example.server.service.LocatonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    LocatonService locatonService;

   

    @PostMapping
    public void addLocation(@RequestBody Location location){
        locatonService.addLocation(location);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getLocationById(@PathVariable Integer id){
        ApiResponse locationById = locatonService.getLocationById(id);
        return ResponseEntity.ok(locationById);
    }
    @GetMapping("/all")
    public HttpEntity<?> getAllLocations(){
        List<Location> allLoctions = locatonService.getAllLoctions();
        return ResponseEntity.ok(getAllLocations());
    }


}
