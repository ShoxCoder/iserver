package com.example.server.entity;

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
@Entity(name = "hospitals")
@PackagePrivate
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @OneToOne
    Location location;

    @ManyToOne
    Region region;

    public Hospital(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}
