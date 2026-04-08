package com.riderrr.app.Entity;


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
    private LocalDateTime InspectionDate;

    public boolean isVisible;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String Availability; // Available / Sold
    private boolean documentsGiven;

    private int Mileage;
    private double Rating;

    //    @Column(length = 1000)
    @OneToMany
    private List<VehicleImage> vehicleImage;

//    private Long userId;

    private LocalDateTime submittedAt;


}

