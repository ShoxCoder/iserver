package com.example.server.twilio;

public interface SmsSenderRepository {
    void  sendSms(SmsRequest smsRequest);
}
