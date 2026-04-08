package com.riderrr.app.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.riderrr.app.Enum.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String customerPhNo;

    @Column(nullable = false)
    private String customerEmail;


    @Column(nullable = false)
    private String Type;

    @Column(nullable = false)
    private String Brand;

    @Column(nullable = false)
    private String Model;

    private int ModelYear;
    private String Colour;

    @Column(unique = true)
    private String RegisterNumber;

    private String OwnerType;


    private double PurchasedAmount;
    private double SellingPrice;
    private double OutLetPrice;


    private LocalDate PurchasedDate;
    private LocalDate SoldDate;


    private String branchId;

    @Column(nullable = false)
    private LocalDate InspectionDate;

    public boolean isVisible;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String Availability; // Available / Sold
    private boolean documentsGiven;

    private int Mileage;
    private double Rating;

    //    @Column(length = 1000)
    @OneToMany(mappedBy = "vehicleId", cascade = CascadeType.ALL,  orphanRemoval = true)
    @JsonManagedReference
    private List<VehicleImage> imagePath;

//    private Long userId;

    private LocalDateTime submittedAt;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getModelYear() {
        return ModelYear;
    }

    public void setModelYear(int modelYear) {
        ModelYear = modelYear;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }

    public String getRegisterNumber() {
        return RegisterNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        RegisterNumber = registerNumber;
    }

    public String getOwnerType() {
        return OwnerType;
    }

    public void setOwnerType(String ownerType) {
        OwnerType = ownerType;
    }

    public double getPurchasedAmount() {
        return PurchasedAmount;
    }

    public void setPurchasedAmount(double purchasedAmount) {
        PurchasedAmount = purchasedAmount;
    }

    public double getSellingPrice() {
        return SellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        SellingPrice = sellingPrice;
    }

    public double getOutLetPrice() {
        return OutLetPrice;
    }

    public void setOutLetPrice(double outLetPrice) {
        OutLetPrice = outLetPrice;
    }

    public LocalDate getPurchasedDate() {
        return PurchasedDate;
    }

    public void setPurchasedDate(LocalDate purchasedDate) {
        PurchasedDate = purchasedDate;
    }

    public LocalDate getSoldDate() {
        return SoldDate;
    }

    public void setSoldDate(LocalDate soldDate) {
        SoldDate = soldDate;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public LocalDate getInspectionDate() {
        return InspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        InspectionDate = inspectionDate;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }

    public boolean isDocumentsGiven() {
        return documentsGiven;
    }

    public void setDocumentsGiven(boolean documentsGiven) {
        this.documentsGiven = documentsGiven;
    }

    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        Mileage = mileage;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

//    public List<VehicleImage> getImagePath() {
//        return imagePath;
//    }
//
//    public List<VehicleImage> setImagePath(List<VehicleImage> imagePath) {
//        imagePath = imagePath;
//    }


    public List<VehicleImage> getImagePath() {
        return imagePath;
    }

    public void setImagePath(List<VehicleImage> imagePath) {
        this.imagePath = imagePath;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

}

