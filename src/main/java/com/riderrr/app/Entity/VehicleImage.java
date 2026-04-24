package com.riderrr.app.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class VehicleImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    @JsonBackReference
    private Vehicle vehicleId;

    private String filePath;

    public Long getVehicleImageId() {
        return id;
    }

    public void setVehicleImageId(Long id) {
        this.id = id;
    }
@JsonIgnore
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
