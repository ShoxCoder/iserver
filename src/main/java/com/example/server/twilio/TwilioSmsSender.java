package com.example.server.twilio;

import com.example.server.payload.ApiResponse;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Random;


@Service("twilio")

public class TwilioSmsSender  {
    private  static final Logger LOGGER= LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    public ApiResponse sendSms(SmsRequest smsRequest) {

        String otp= generateOTP();
        String message="Dear patient your registration code is "+otp+".!.";

        if (isPhoneNumberValid(smsRequest.getPhoneNumber())){
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            MessageCreator creator = Message.creator(to, from,message);
            creator.create();
            LOGGER.info("send sms {}"+smsRequest);
        return new ApiResponse(otp,true);
        }
        return new ApiResponse("Not Valid",false);
        }

    private String generateOTP(){
        return new DecimalFormat("000000")

                .format(new Random().nextInt(999999));



    }



    private boolean isPhoneNumberValid(String phoneNumber) {
        return true;
    }
}
