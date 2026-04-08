package com.riderrr.app.Entity;

import jakarta.persistence.*;

@Entity
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicleId;

    private String Engine;
    private String Tyre;
    private String Brake;
    private String Seat;
    private String Wheel;
    private String Body;
    private String Handles;
    private String MeterBoard;
    private String Light;
    private String Exhaust;
    private String AirFilter;
    private String Damage;
    private String Battery;
    private String Mileage;
    private String KmDriven;
    private String Gear;
    private String ShockAbsorber;
    private String Modification;


}
