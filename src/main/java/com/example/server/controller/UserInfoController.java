package com.example.server.controller;

import com.example.server.entity.UserInfo;
import com.example.server.payload.ApiResponse;
import com.example.server.payload.UserInfoDto;
import com.example.server.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserInfoController {
    @Autowired
    UserInfoService userService;

    @PostMapping
   public HttpEntity<?> addUser(@RequestBody UserInfoDto userDTO){
        ApiResponse apiResponce = userService.saveUser(userDTO);
        return ResponseEntity.status(apiResponce.isSuccess()?201:409).body(apiResponce);
    }
    @GetMapping("/all")
    public HttpEntity<?> getUsers(){
        List<UserInfo> all = userService.getAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> oneUser(@PathVariable Integer id){
        UserInfo user = userService.oneUser(id);
        return ResponseEntity.ok(user);
    }
     @PutMapping("/{id}")
    public HttpEntity<?> editUser(@RequestBody UserInfoDto userDTO, @PathVariable Integer id){
         ApiResponse apiResponce = userService.editUser(userDTO, id);

         return ResponseEntity.status(apiResponce.isSuccess()?201:409).body(apiResponce);
     }
     @DeleteMapping("/{id}")

    public HttpEntity<?> deleteUser(@PathVariable Integer id){
         ApiResponse apiResponce = userService.deleteUser(id);
         return ResponseEntity.status(apiResponce.isSuccess()?201:404).body(apiResponce);
     }
 }
