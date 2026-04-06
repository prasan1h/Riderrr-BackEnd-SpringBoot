package com.riderrr.app.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    //    @Column(nullable = false)
    private String customerName;

    //    @Column(nullable = false, unique = true)
    private String customerPhNo;

    //    @Column(nullable = false)
    private String customerEmail;


    private String executiveName;


    //    @Column(nullable = false)
    private String vehicleType; // bike, car

    //    @Column(nullable = false)
    private String vehicleBrand;

    //    @Column(nullable = false)
    private String vehicleModel;

    private int vehicleModelYear;
    private String vehicleColour;

    //    @Column(unique = true)
    private String vehicleRegisterNumber;

    private String vehicleOwnerType;


    private double vehiclePurchasedAmount;
    private double vehicleSellingPrice;
    private double vehicleOutLetPrice;


    private LocalDate vehiclePurchasedDate;
    private LocalDate vehicleSoldDate;


    private Long inspectionId;


    private String vehicleInspectionBranch;

    //    @Column(nullable = false)
    private LocalDate vehicleInspectionDate;


    private String vehicleAvailability; // Available / Sold
    private boolean documentsGiven;
    private boolean websiteVisibility;

    private int vehicleMileage;
    private double vehicleRating;

    //    @Column(length = 1000)
    private String vehicleImage;

    private Long userId;
    private Long branchId;
    private LocalDateTime submittedAt;


    public Vehicle() {}


    public Long getVehicleId() {
        return vehicleId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhNo() {
        return customerPhNo;
    }

    public void setCustomerPhNo(String customerPhNo) {
        this.customerPhNo = customerPhNo;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getExecutiveName() {
        return executiveName;
    }

    public void setExecutiveName(String executiveName) {
        this.executiveName = executiveName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getVehicleModelYear() {
        return vehicleModelYear;
    }

    public void setVehicleModelYear(int vehicleModelYear) {
        this.vehicleModelYear = vehicleModelYear;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public String getVehicleRegisterNumber() {
        return vehicleRegisterNumber;
    }

    public void setVehicleRegisterNumber(String vehicleRegisterNumber) {
        this.vehicleRegisterNumber = vehicleRegisterNumber;
    }

    public String getVehicleOwnerType() {
        return vehicleOwnerType;
    }

    public void setVehicleOwnerType(String vehicleOwnerType) {
        this.vehicleOwnerType = vehicleOwnerType;
    }

    public double getVehiclePurchasedAmount() {
        return vehiclePurchasedAmount;
    }

    public void setVehiclePurchasedAmount(double vehiclePurchasedAmount) {
        this.vehiclePurchasedAmount = vehiclePurchasedAmount;
    }

    public double getVehicleSellingPrice() {
        return vehicleSellingPrice;
    }

    public void setVehicleSellingPrice(double vehicleSellingPrice) {
        this.vehicleSellingPrice = vehicleSellingPrice;
    }

    public double getVehicleOutLetPrice() {
        return vehicleOutLetPrice;
    }

    public void setVehicleOutLetPrice(double vehicleOutLetPrice) {
        this.vehicleOutLetPrice = vehicleOutLetPrice;
    }

    public LocalDate getVehiclePurchasedDate() {
        return vehiclePurchasedDate;
    }

    public void setVehiclePurchasedDate(LocalDate vehiclePurchasedDate) {
        this.vehiclePurchasedDate = vehiclePurchasedDate;
    }

    public LocalDate getVehicleSoldDate() {
        return vehicleSoldDate;
    }

    public void setVehicleSoldDate(LocalDate vehicleSoldDate) {
        this.vehicleSoldDate = vehicleSoldDate;
    }

    public Long getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(Long inspectionId) {
        this.inspectionId = inspectionId;
    }

    public String getVehicleInspectionBranch() {
        return vehicleInspectionBranch;
    }

    public void setVehicleInspectionBranch(String vehicleInspectionBranch) {
        this.vehicleInspectionBranch = vehicleInspectionBranch;
    }

    public LocalDate getVehicleInspectionDate() {
        return vehicleInspectionDate;
    }

    public void setVehicleInspectionDate(LocalDate vehicleInspectionDate) {
        this.vehicleInspectionDate = vehicleInspectionDate;
    }

    public String getVehicleAvailability() {
        return vehicleAvailability;
    }

    public void setVehicleAvailability(String vehicleAvailability) {
        this.vehicleAvailability = vehicleAvailability;
    }

    public boolean isDocumentsGiven() {
        return documentsGiven;
    }

    public void setDocumentsGiven(boolean documentsGiven) {
        this.documentsGiven = documentsGiven;
    }

    public boolean isWebsiteVisibility() {
        return websiteVisibility;
    }

    public void setWebsiteVisibility(boolean websiteVisibility) {
        this.websiteVisibility = websiteVisibility;
    }

    public int getVehicleMileage() {
        return vehicleMileage;
    }

    public void setVehicleMileage(int vehicleMileage) {
        this.vehicleMileage = vehicleMileage;
    }

    public double getVehicleRating() {
        return vehicleRating;
    }

    public void setVehicleRating(double vehicleRating) {
        this.vehicleRating = vehicleRating;
    }

    public String getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(String vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}

