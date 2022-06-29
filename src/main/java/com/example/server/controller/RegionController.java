package com.example.server.controller;

import com.example.server.entity.Region;
import com.example.server.payload.ApiResponse;
import com.example.server.payload.RegionDto;
import com.example.server.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/region")
public class RegionController {
    @Autowired
    RegionService regionService;

    @GetMapping("/all")
    public HttpEntity<?> getAllRegions(){
        List<Region> allRegions = regionService.getAllRegions();
        return ResponseEntity.ok(allRegions);
    }

    @PostMapping
    public HttpEntity<?> addRegion(@RequestBody RegionDto regionDto){
        ApiResponse apiResponse = regionService.addRegion(regionDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editRegion(@RequestBody RegionDto regionDto, @PathVariable Integer id){
        ApiResponse apiResponse = regionService.updateRegion(regionDto, id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getRegionById(@PathVariable Integer id){
        ApiResponse apiResponse = regionService.getRegionById(id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteRegionById(@PathVariable Integer id){
        ApiResponse apiResponse = regionService.deleteRegion(id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
}
