package com.riderrr.app.Entity;

import jakarta.persistence.*;

@Entity
public class VehicleImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleImageId;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;

    private String filePath;
}
