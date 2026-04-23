package com.riderrr.app.Service;

import com.riderrr.app.Enum.TestRideStatus;
import com.riderrr.app.Entity.Branch;
import com.riderrr.app.Entity.TestRide;
import com.riderrr.app.Entity.Vehicle;
//import com.riderrr.app.Repository.BranchRepository;
import com.riderrr.app.Repository.TestRideRepository;
import com.riderrr.app.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

    @Service
    public class TestRideService {

        @Autowired
        private TestRideRepository testRideRepository;
        @Autowired
        private VehicleRepository vehicleRepository;
//        @Autowired
//        private BranchRepository branchRepository;

        public TestRide createTestRideRequest(Long vehicleId, Long branchId, String customerName,
                                              String customerPhone, String customerEmail, LocalDate requestedDate) {
            Vehicle vehicle = vehicleRepository.findById(vehicleId)
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));
//            Branch branch = branchRepository.findById(branchId)
//                    .orElseThrow(() -> new RuntimeException("Branch not found"));

            TestRide testRide = new TestRide();
            testRide.setVehicle(vehicle);
//            testRide.setBranch(branch);
            testRide.setCustomerName(customerName);
            testRide.setCustomerPhone(customerPhone);
            testRide.setCustomerEmail(customerEmail);
            testRide.setRequestedDate(requestedDate);
            testRide.setStatus(TestRideStatus.PENDING);

            return testRideRepository.save(testRide);
        }

        public List<TestRide> getAllPendingRequests() {
            return testRideRepository.findByStatus(TestRideStatus.PENDING);
        }

        public List<TestRide> getPendingRequestsByBranch(Long branchId) {
            return testRideRepository.findByBranch_IdAndStatus(branchId, TestRideStatus.PENDING);
        }

        public TestRide updateStatus(Long testRideId, TestRideStatus status, String staffRemarks) {
            TestRide testRide = testRideRepository.findById(testRideId)
                    .orElseThrow(() -> new RuntimeException("Test Ride not found"));

            testRide.setStatus(status);
            if (staffRemarks != null && !staffRemarks.isEmpty()) {
                testRide.setStaffRemarks(staffRemarks);
            }
            return testRideRepository.save(testRide);
        }
    }

