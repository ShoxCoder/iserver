package com.example.server.controller;

import com.example.server.entity.Driver;
import com.example.server.payload.ApiResponse;
import com.example.server.payload.DriverDto;
import com.example.server.service.DriverService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverController {


  private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public HttpEntity<?> addDriver(@RequestBody DriverDto driverDto){
        ApiResponse apiResponse = driverService.addDriver(driverDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAllDrivers(){
        List<Driver> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getDriverById(@PathVariable Integer id){
        ApiResponse one = driverService.getOne(id);
        return ResponseEntity.ok(one);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@RequestBody DriverDto driverDto){
        ApiResponse edit = driverService.edit(id, driverDto);
        return ResponseEntity.status(edit.isSuccess()?201:409).body(edit);
    }
    @DeleteMapping("{id}")
    public HttpEntity<?> deleteDriver(@PathVariable Integer id){
        ApiResponse delete = driverService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?201:409).body(delete);

    }

}
