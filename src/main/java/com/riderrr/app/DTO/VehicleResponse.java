package com.riderrr.app.DTO;

import com.riderrr.app.Enum.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class VehicleResponse {

    private Long id;
    private String brand;
    private String type;
    private String model;
    private Integer modelYear;
    private String color;
    private LocalDate purchaseDate;
    private Double PurchasedAmount;
    private String ownerType;
    private String registrationNumber;
    private List<String> images;
    private LocalDate inspectionDate;
    private String inspectionBranch;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private double sellingPrice;
    private double outLetPrice;
    private LocalDate SoldDate;
    private LocalDate InspectionDate;
    public boolean isVisible;
    private boolean documentsGiven;
    private int Mileage;
    private double Rating;
    private LocalDateTime submittedAt;
    private Status status;
    private String Availability;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getPurchasedAmount() {
        return PurchasedAmount;
    }

    public void setPurchasedAmount(Double purchasedAmount) {
        PurchasedAmount = purchasedAmount;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getInspectionBranch() {
        return inspectionBranch;
    }

    public void setInspectionBranch(String inspectionBranch) {
        this.inspectionBranch = inspectionBranch;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getOutLetPrice() {
        return outLetPrice;
    }

    public void setOutLetPrice(double outLetPrice) {
        this.outLetPrice = outLetPrice;
    }

    public LocalDate getSoldDate() {
        return SoldDate;
    }

    public void setSoldDate(LocalDate soldDate) {
        SoldDate = soldDate;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
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

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
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


}
