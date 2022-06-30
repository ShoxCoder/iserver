package com.example.server.twilio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class  SmsRequest {

    @NotBlank
    private final String phoneNumber;
    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber) {
        this.phoneNumber = phoneNumber;

}






}
