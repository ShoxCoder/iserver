package com.example.server.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.PackagePrivate;

// Nurkulov Nodirbek 5/19/2022  5:26 AM
@PackagePrivate
@Getter
@Setter
public class HospitalDto {
    Integer id;

    String name;

    Integer locationId;

    Integer  regionId;
}
