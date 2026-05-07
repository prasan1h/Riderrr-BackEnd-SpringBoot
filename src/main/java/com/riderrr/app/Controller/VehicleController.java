package com.riderrr.app.Controller;

import com.riderrr.app.DTO.VehicleDTO;
import com.riderrr.app.DTO.VehicleFilterDTO;
import com.riderrr.app.DTO.VehicleResponse;
import com.riderrr.app.Entity.Vehicle;
import com.riderrr.app.Enum.Status;
import com.riderrr.app.Service.Staff.InspectVehicle;
import com.riderrr.app.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5173","http://localhost:5173"})
@RequestMapping("/bike")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    InspectVehicle inspectVehicleService;

    @Autowired
    VehicleDTO vehicleDTO;

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
            @RequestParam String customerEmail,
            @RequestParam String branchId
    )
            throws IOException
    {
        return vehicleService.add(
                brand, type, model, modelYear, color, purchaseDate, PurchasedAmount, ownerType, registrationNumber, images, inspectionDate, inspectionBranch, customerName, customerPhone, customerEmail,branchId
        );
    }

    @GetMapping("/all")
    public List<VehicleResponse> all()
    {
        return vehicleService.all();
    }

    @GetMapping("findById")
    public VehicleResponse findById(
            @RequestParam Long id
    ){
        return vehicleService.findById(id);
    }

    @GetMapping("/pendingAll")
    public List<VehicleResponse> findPendingStatus(){
        return vehicleService.findStatus(Status.PENDING);
    }

    @GetMapping("/draftAll")
    public List<VehicleResponse> findDraftStatus(){
        return vehicleService.findStatus(Status.DRAFT);
    }

    @GetMapping("/approvedAll")
    public List<VehicleResponse> findApprovedStatus(){
        return vehicleService.findStatus(Status.APPROVED);
    }

    @GetMapping("/acceptedAll")
    public List<VehicleResponse> findAcceptedStatus(){
        return vehicleService.findStatus(Status.ACCEPTED);
    }

    @GetMapping("/findAtBuy")
    public List<VehicleResponse> findAtBuy(){
        return vehicleService.findAcceptedVisibleAvailableVehicles();
    }

    @GetMapping("/findRecent")
    public List<VehicleResponse> findRecent(){
        return vehicleService.findRecent();
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
            @RequestParam double Rating,
            @RequestParam int Mileage,
            @RequestParam MultipartFile[] images
    )
            throws IOException
    {
        return vehicleService.updateVehicleByManager(
                id, outLetPrice, isVisible, Mileage, images, Rating
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



    @GetMapping("/findAtBuyPage")
    public ResponseEntity<Map<String, Object>> findAtBuyPage(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) List<String> brand,
            @RequestParam(required = false) List<String> color,
            @RequestParam(required = false) List<String> price,
            @RequestParam(required = false) List<String> year,
            @RequestParam(required = false, defaultValue = "") String sortBy,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "9") int size
    ) {
        VehicleFilterDTO req = new VehicleFilterDTO();
        req.setSearch(search);
        req.setBrand(brand);
        req.setColor(color);
        req.setPrice(price);
        req.setYear(year);
        req.setSortBy(sortBy);
        req.setPage(page);
        req.setSize(size);

        Page<Vehicle> result = vehicleService.findAtBuyPage(req);

        List<VehicleResponse> content = result.getContent()
                .stream()
                .map(vehicleDTO::readDTO)
                .toList();

        Map<String, Object> response = new HashMap<>();
        response.put("content", content);
        response.put("totalElements", result.getTotalElements());
        response.put("totalPages", result.getTotalPages());
        response.put("currentPage", result.getNumber());
        response.put("isLast", result.isLast());

        return ResponseEntity.ok(response);
    }

}
