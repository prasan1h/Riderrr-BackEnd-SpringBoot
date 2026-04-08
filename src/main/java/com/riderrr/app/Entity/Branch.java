package com.riderrr.app.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Name;
    private String Location;
    private String City;
    private String Phone;
    private String Email;
    private String Address;

}
