package com.riderrr.app.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class VehicleImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ImageId;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    @JsonBackReference
    private Vehicle vehicleId;

    private String filePath;

    public Long getVehicleImageId() {
        return ImageId;
    }

    public void setVehicleImageId(Long vehicleImageId) {
        this.ImageId = vehicleImageId;
    }

    public Vehicle getVehicle() {
        return vehicleId;
    }

    public void setVehicle(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
