package com.riderrr.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VehicleImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleImageId;

    private Long v_id;
    private String filePath;
}
