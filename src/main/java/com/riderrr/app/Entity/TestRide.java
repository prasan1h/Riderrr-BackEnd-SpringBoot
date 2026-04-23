package com.riderrr.app.Entity;

import com.riderrr.app.Enum.TestRideStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

    @Entity
    public class TestRide {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "vehicleId")
        private Vehicle vehicle;

        @ManyToOne
        @JoinColumn(name = "branchId")
        private Branch branch;

        private String customerName;
        private String customerPhone;
        private String customerEmail;

        private LocalDate requestedDate;

        @Enumerated(EnumType.STRING)
        private TestRideStatus status;

        private String staffRemarks;

        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public Vehicle getVehicle() { return vehicle; }
        public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

        public Branch getBranch() { return branch; }
        public void setBranch(Branch branch) { this.branch = branch; }

        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }

        public String getCustomerPhone() { return customerPhone; }
        public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }

        public String getCustomerEmail() { return customerEmail; }
        public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

        public LocalDate getRequestedDate() { return requestedDate; }
        public void setRequestedDate(LocalDate requestedDate) { this.requestedDate = requestedDate; }

        public TestRideStatus getStatus() { return status; }
        public void setStatus(TestRideStatus status) { this.status = status; }

        public String getStaffRemarks() { return staffRemarks; }
        public void setStaffRemarks(String staffRemarks) { this.staffRemarks = staffRemarks; }
    }

