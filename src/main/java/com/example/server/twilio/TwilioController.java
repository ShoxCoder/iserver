package com.example.server.twilio;

import com.example.server.payload.ApiResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/sms")
public class TwilioController {
    private final TwilioSmsSender service;

    public TwilioController(TwilioSmsSender service) {
        this.service = service;
    }

    @PostMapping
    public HttpEntity<?> sendSms(@Valid  @RequestBody SmsRequest smsRequest){

        ApiResponse apiResponse = service.sendSms(smsRequest);
        return ResponseEntity.ok(apiResponse);
    }

}
