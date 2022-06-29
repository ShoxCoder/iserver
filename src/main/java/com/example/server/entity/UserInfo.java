package com.example.server.entity;

import com.example.server.entity.attachment.Attachment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.PackagePrivate;


import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
@PackagePrivate
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String firstName;

    String lastName;

    String phoneNumber;

    Integer age;

    Integer weight;

    Integer height;
    @OneToOne
    Location location;

    @OneToOne
    Attachment patientPhoto;

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

    String jShir;

    String serialNumber;



}
