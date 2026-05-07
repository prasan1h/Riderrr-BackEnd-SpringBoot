
package com.riderrr.app.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.riderrr.app.Enum.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String customerPhNo;

    @Column(nullable = false)
    private String customerEmail;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    private int modelYear;
    private String colour;

    @Column(unique = true)
    private String registerNumber;

    private String ownerType;

    private double purchasedAmount;
    private double sellingPrice;
    private double outLetPrice;

    private LocalDate purchasedDate;
    private LocalDate soldDate;

    private String branchId;

    @Column(nullable = false)
    private LocalDate inspectionDate;
    private String inspectionBranch;

    public boolean isVisible;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;

    private String availability = "AVAILABLE";
    private boolean documentsGiven;

    private int mileage;
    private double rating;

    @OneToMany(mappedBy = "vehicleId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<VehicleImage> imagePath;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime submittedAt;

    // ---- Getters & Setters ----

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerPhNo() { return customerPhNo; }
    public void setCustomerPhNo(String customerPhNo) { this.customerPhNo = customerPhNo; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getModelYear() { return modelYear; }
    public void setModelYear(int modelYear) { this.modelYear = modelYear; }

    public String getColour() { return colour; }
    public void setColour(String colour) { this.colour = colour; }

    public String getRegisterNumber() { return registerNumber; }
    public void setRegisterNumber(String registerNumber) { this.registerNumber = registerNumber; }

    public String getOwnerType() { return ownerType; }
    public void setOwnerType(String ownerType) { this.ownerType = ownerType; }

    public double getPurchasedAmount() { return purchasedAmount; }
    public void setPurchasedAmount(double purchasedAmount) { this.purchasedAmount = purchasedAmount; }

    public double getSellingPrice() { return sellingPrice; }
    public void setSellingPrice(double sellingPrice) { this.sellingPrice = sellingPrice; }

    public double getOutLetPrice() { return outLetPrice; }
    public void setOutLetPrice(double outLetPrice) { this.outLetPrice = outLetPrice; }

    public LocalDate getPurchasedDate() { return purchasedDate; }
    public void setPurchasedDate(LocalDate purchasedDate) { this.purchasedDate = purchasedDate; }

    public LocalDate getSoldDate() { return soldDate; }
    public void setSoldDate(LocalDate soldDate) { this.soldDate = soldDate; }

    public String getBranchId() { return branchId; }
    public void setBranchId(String branchId) { this.branchId = branchId; }

    public LocalDate getInspectionDate() { return inspectionDate; }
    public void setInspectionDate(LocalDate inspectionDate) { this.inspectionDate = inspectionDate; }

    public String getInspectionBranch() { return inspectionBranch; }
    public void setInspectionBranch(String inspectionBranch) { this.inspectionBranch = inspectionBranch; }

    public boolean isVisible() { return isVisible; }
    public void setVisible(boolean visible) { isVisible = visible; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    public boolean isDocumentsGiven() { return documentsGiven; }
    public void setDocumentsGiven(boolean documentsGiven) { this.documentsGiven = documentsGiven; }

    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public List<VehicleImage> getImagePath() { return imagePath; }
    public void setImagePath(List<VehicleImage> imagePath) { this.imagePath = imagePath; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }
}