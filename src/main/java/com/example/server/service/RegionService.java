package com.example.server.service;

import com.example.server.entity.Region;
import com.example.server.payload.ApiResponse;
import com.example.server.payload.RegionDto;
import com.example.server.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    RegionRepository regionRepository;

    public List<Region> getAllRegions() {
        List<Region> all = regionRepository.findAll();
        return all;
    }

    public ApiResponse addRegion(RegionDto regionDto) {
        boolean existsByName = regionRepository.existsByName(regionDto.getName());
        if (existsByName) {
            return new ApiResponse("Bunday Region oldin mavjud", false);
        }
        Region region = new Region();
        region.setName(regionDto.getName());
        Region savedRegion = regionRepository.save(region);
        return new ApiResponse("Success", true, savedRegion);
    }

    public ApiResponse updateRegion(RegionDto regionDto, Integer id) {
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (!optionalRegion.isPresent()) {
            return new ApiResponse("Bunday Region topilmadi", false, null);
        }
        Region region = optionalRegion.get();
        region.setName(regionDto.getName());
        Region savedRegion = regionRepository.save(region);
        return new ApiResponse("Success", true, savedRegion);
    }

    public ApiResponse getRegionById(Integer id) {
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (!optionalRegion.isPresent()) {
            return new ApiResponse("Bunday Region topilmadi", false, null);
        }
        return new ApiResponse("Ok", true, optionalRegion.get());
    }

    public ApiResponse deleteRegion(Integer id) {
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (!optionalRegion.isPresent()) {
            return new ApiResponse("Bunday Region topilmadi", false, null);
        }
        regionRepository.deleteById(id);
        return new ApiResponse("Ok", true, optionalRegion.get());
    }
}
