package com.riderrr.app.Controller;

import com.riderrr.app.Enum.Status;
import com.riderrr.app.Entity.Inspection;
import com.riderrr.app.Service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
@RequestMapping("/api/inspection")
public class InspectionController {

    @Autowired
    private InspectionService inspectionService;

    @GetMapping("/pending")
    public List<Inspection> getPendingInspections() {
        return inspectionService.getInspectionsByVehicleStatus(Status.PENDING);
    }

    @PostMapping("/draft")
    public Inspection saveDraftInspection(@RequestParam Long vehicleId, @RequestBody Inspection inspectionData) {
        return inspectionService.saveInspectionAsDraft(vehicleId, inspectionData);
    }

    @PostMapping("/submit")
    public Inspection submitInspection(@RequestParam Long vehicleId, @RequestBody Inspection inspectionData) {
        return inspectionService.submitInspection(vehicleId, inspectionData);
    }

    @GetMapping("/review-list")
    public List<Inspection> getInspectionsForReview() {
        return inspectionService.getInspectionsByVehicleStatus(Status.APPROVED);
    }

    @PostMapping("/accept")
    public String acceptAndPublishVehicle(
            @RequestParam Long vehicleId,
            @RequestParam double outLetPrice,
            @RequestParam int mileage) {
        inspectionService.acceptAndPublish(vehicleId, outLetPrice, mileage);
        return "Vehicle accepted and published successfully!";
    }

    @GetMapping("/report/{vehicleId}")
    public Inspection getInspectionReport(@PathVariable Long vehicleId) {
        return inspectionService.getInspectionByVehicleId(vehicleId);
    }
}
