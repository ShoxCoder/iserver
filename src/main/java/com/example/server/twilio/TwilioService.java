package com.example.server.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



@org.springframework.stereotype.Service
public class TwilioService {
    private final SmsSenderRepository SmsSender;

   @Autowired
   SmsSenderRepository smsRequest;

    @Autowired
    public TwilioService(@Qualifier("twilio") TwilioSmsSender SmsSender) {
        this.SmsSender = SmsSender;
    }


     public void sendSms(SmsRequest smsRequest){
        

        SmsSender.sendSms(smsRequest);
     }



}
