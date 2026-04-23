package com.riderrr.app.Controller;

import com.riderrr.app.Enum.TestRideStatus;
import com.riderrr.app.Entity.TestRide;
import com.riderrr.app.Service.TestRideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
@RequestMapping("/api/test-ride")
public class TestRideController {

    @Autowired
    private TestRideService testRideService;

    @PostMapping("/request")
    public TestRide requestTestRide(
            @RequestParam Long vehicleId,
            @RequestParam Long branchId,
            @RequestParam String customerName,
            @RequestParam String customerPhone,
            @RequestParam String customerEmail,
            @RequestParam LocalDate requestedDate) {
        return testRideService.createTestRideRequest(
                vehicleId, branchId, customerName, customerPhone, customerEmail, requestedDate
        );
    }

    @GetMapping("/staff/pending")
    public List<TestRide> getPendingRequests(@RequestParam(required = false) Long branchId) {
        if (branchId != null) {
            return testRideService.getPendingRequestsByBranch(branchId);
        }
        return testRideService.getAllPendingRequests();
    }

    @PostMapping("/staff/update-status")
    public TestRide updateTestRideStatus(
            @RequestParam Long testRideId,
            @RequestParam TestRideStatus status,
            @RequestParam(required = false) String staffRemarks) {
        return testRideService.updateStatus(testRideId, status, staffRemarks);
    }
}
