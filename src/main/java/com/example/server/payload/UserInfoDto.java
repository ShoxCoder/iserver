package com.example.server.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.PackagePrivate;

@Getter
@Setter
@PackagePrivate
public class UserInfoDto {
    String firstName;
    String lastName;
    String phoneNumber;
    Integer age;
    String jShir;
    String  serialNumber;
    Integer weight;
    Integer height;
    Integer patientPhoto_Id;
    String callStatus;
    Integer cardNumber;
    Integer bloodGroup;
    String cameAmbulance;
    String districtName;
    String street;
    String apartment;
    String homeNumber;
    String callPatient;
    String residenceAddress;
    String illnessInfo;
    Integer location_id;
}
