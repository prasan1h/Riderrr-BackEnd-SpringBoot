package com.riderrr.app.Service.Staff;

import com.riderrr.app.DTO.VehicleDTO;
import com.riderrr.app.DTO.VehicleResponse;
import com.riderrr.app.Repository.VehicleRepository;
import com.riderrr.app.Util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

public class InspectVehicle {
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    VehicleDTO vehicleDTO;

    public VehicleResponse update(Long id, String brand, String type, String model, String modelYear, String color, LocalDate purchaseDate, Double purchasedAmount, String ownerType, String registrationNumber, MultipartFile[] images, LocalDate inspectionDate, String inspectionBranch, String customerName, String customerPhone, String customerEmail)
            throws IOException
    {

    }
}
