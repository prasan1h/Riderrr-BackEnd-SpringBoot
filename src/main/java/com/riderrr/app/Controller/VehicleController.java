package com.riderrr.app.Controller;

import com.riderrr.app.DTO.VehicleResponse;
import com.riderrr.app.Enum.Status;
import com.riderrr.app.Service.Staff.InspectVehicle;
import com.riderrr.app.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5173/","http://localhost:5173/"})
@RequestMapping("/api/bike")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    InspectVehicle inspectVehicleService;

    @GetMapping("/")
    public String bike() {
        return "this /api/bike";
    }

    @PostMapping("/add")
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

    @GetMapping("/all")
    public List<VehicleResponse> all()
    {
        return vehicleService.all();
    }

    @PutMapping("/status")
    public VehicleResponse updateVehicleStatus(
            @RequestParam Long id,
            @RequestParam Status status
    )
            throws IOException
    {
        return vehicleService.updateVehicleStatus(
                id, status
        );
    }

    @PutMapping("/visibility")
    public VehicleResponse updateVehicleVisibility(
            @RequestParam Long id,
            @RequestParam Boolean isVisible
    )
            throws IOException
    {
        return vehicleService.updateVehicleVisibility(
                id, isVisible
        );
    }

    @PutMapping("/availability")
    public VehicleResponse updateVehicleAvailability(
            @RequestParam Long id,
            @RequestParam String Availability
    )
            throws IOException
    {
        return vehicleService.updateVehicleAvailability(
                id,  Availability
        );
    }


    @PutMapping("/manager/updates")
    public VehicleResponse updateVehicleByManager(
            @RequestParam Long id,
            @RequestParam double outLetPrice,
            @RequestParam Boolean isVisible,
            @RequestParam int Mileage,
            @RequestParam MultipartFile[] images
    )
            throws IOException
    {
        return vehicleService.updateVehicleByManager(
                id, outLetPrice, isVisible, Mileage, images
        );
    }

    @PutMapping("/manager/soldUpdates")
    public VehicleResponse soldDetailsUpdate(
            @RequestParam Long id,
            @RequestParam String Availability,
            @RequestParam LocalDate SoldDate,
            @RequestParam double sellingPrice,
            @RequestParam String customerName,
            @RequestParam String customerPhone,
            @RequestParam boolean documentsGiven
    )
        throws IOException
    {
            return vehicleService.soldDetailsUpdate(
                    id, Availability, SoldDate, sellingPrice, customerName, customerPhone, documentsGiven
            );
    }

    @PutMapping("/manager/edit")
    public VehicleResponse editVehicleDetails(
            @RequestParam Long id,
            @RequestParam String brand,
            @RequestParam String type,
            @RequestParam String model,
            @RequestParam String modelYear,
            @RequestParam String color,
            @RequestParam LocalDate purchaseDate,
            @RequestParam Double PurchasedAmount,
            @RequestParam String ownerType,
            @RequestParam String registrationNumber,
            @RequestParam String inspectionBranch,
            @RequestParam LocalDate inspectionDate,
            @RequestParam Boolean isVisible,
            @RequestParam int Mileage,
            @RequestParam double outLetPrice

    )
        throws IOException
    {
        return vehicleService.editVehicleDetails(
                id, brand, type, model, modelYear, color, purchaseDate, PurchasedAmount, ownerType, registrationNumber, inspectionDate, inspectionBranch, isVisible, Mileage, outLetPrice
        );
    }

}
