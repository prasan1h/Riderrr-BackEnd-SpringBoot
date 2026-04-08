package com.riderrr.app.Controller.Website;

import com.riderrr.app.Entity.Vehicle;
import com.riderrr.app.Service.Website.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/api/bike")
    public String bike() {
        return "this /api/bike";
    }

    @PostMapping("/api/add")
    public Vehicle add(
            @RequestParam String brand,
            @RequestParam String type,
            @RequestParam String model,
            @RequestParam String modelYear,
            @RequestParam String color,
            @RequestParam LocalDate purchaseDate,
            @RequestParam Double purchasePrice,
            @RequestParam String ownerType,
            @RequestParam String registrationNumber,
            @RequestParam MultipartFile[] images,
            @RequestParam LocalDate inspectionDate,
            @RequestParam String inspectionBranch,
            @RequestParam String customerName,
            @RequestParam String customerPhone,
            @RequestParam String customerEmail
    )
            throws IOException
    {
        return vehicleService.add(
                brand, type, model, modelYear, color, purchaseDate, purchasePrice, ownerType, registrationNumber, images, inspectionDate, inspectionBranch, customerName, customerPhone, customerEmail
        );
    }
}
