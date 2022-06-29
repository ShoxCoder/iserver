package com.example.server.controller;

import com.example.server.entity.IllnessInfo;
import com.example.server.payload.ApiResponse;
import com.example.server.payload.IllnessInfoDto;
import com.example.server.service.IllnessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/illness")
public class IllnessInfoController {

    @Autowired

    IllnessInfoService illnessService;

    @PostMapping
    public HttpEntity<?> addIllnessInfo(@RequestBody IllnessInfoDto illnessDto){

        ApiResponse apiResponse = illnessService.addIllnessInfo(illnessDto);

        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAllIllnessInfo(){
        List<IllnessInfo> all = illnessService.getAll();

        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")

    public HttpEntity<?>  getOneIllnesInfo(@PathVariable Integer id){
        IllnessInfo one = illnessService.getOne(id);
        return ResponseEntity.ok(one);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@RequestBody IllnessInfoDto illnessInfoDto,@PathVariable Integer id){
        ApiResponse edit = illnessService.edit(illnessInfoDto, id);

        return ResponseEntity.status(edit.isSuccess()?201:409).body(edit);

    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteInfo(@PathVariable Integer id){

        ApiResponse apiResponse = illnessService.deleteInfo(id);
        return ResponseEntity.ok(apiResponse);
    }



}
