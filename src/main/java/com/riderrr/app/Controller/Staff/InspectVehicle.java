package com.riderrr.app.Controller.Staff;

import com.riderrr.app.DTO.VehicleResponse;
import com.riderrr.app.Entity.Vehicle;
import com.riderrr.app.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Service
public class InspectVehicle {

    @Autowired
    VehicleRepository vehicleRepository;


    public VehicleResponse update(Long id, String brand, String type, String model, String modelYear, String color, LocalDate purchaseDate, Double purchasedAmount, String ownerType, String registrationNumber, MultipartFile[] images, LocalDate inspectionDate, String inspectionBranch, String customerName, String customerPhone, String customerEmail) {
        Vehicle v =  vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));

     }
}
