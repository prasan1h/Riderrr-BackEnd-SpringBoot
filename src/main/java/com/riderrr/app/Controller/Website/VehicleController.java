package com.riderrr.app.Controller.Website;

import com.riderrr.app.DTO.VehicleResponse;
import com.riderrr.app.Entity.Vehicle;
import com.riderrr.app.Service.Website.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173","http://127.0.0.1:5173/"})
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/api/bike")
    public String bike() {
        return "this /api/bike";
    }

    @PostMapping("/api/bike/add")
    public VehicleResponse add(
            @RequestParam String brand,
            @RequestParam String type,
            @RequestParam String model,
            @RequestParam String modelYear,
            @RequestParam String color,
            @RequestParam LocalDate purchaseDate,
            @RequestParam Double PurchasedAmount,
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
                brand, type, model, modelYear, color, purchaseDate, PurchasedAmount, ownerType, registrationNumber, images, inspectionDate, inspectionBranch, customerName, customerPhone, customerEmail
        );
    }

    @GetMapping("/api/bike/all")
    public List<VehicleResponse> all()
    {
        return vehicleService.all();
    }
}
