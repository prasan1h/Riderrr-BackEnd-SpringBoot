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

    public Long getVehicleImageId() {
        return vehicleImageId;
    }

    public void setVehicleImageId(Long vehicleImageId) {
        this.vehicleImageId = vehicleImageId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
