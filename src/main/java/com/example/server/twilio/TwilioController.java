package com.example.server.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/sms")
public class TwilioController {
    private final TwilioService service;
    @Autowired
    public TwilioController(TwilioService service) {
        this.service = service;
    }
    @PostMapping
    public void sendSms(@Valid  @RequestBody SmsRequest smsRequest){

        service.sendSms(smsRequest);
    }
}
