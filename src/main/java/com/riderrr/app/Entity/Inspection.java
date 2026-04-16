package com.riderrr.app.Entity;

import jakarta.persistence.*;

@Entity
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicleId;

    private String Engine;
    private String Tyre;
    private String Brake;
    private String Seat;
    private String Wheel;
    private String Body;
    private String Handles;
    private String MeterBoard;
    private String Light;
    private String Exhaust;
    private String AirFilter;
    private String Damage;
    private String Battery;
    private String Mileage;
    private String KmDriven;
    private String Gear;
    private String ShockAbsorber;
    private String Modification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getEngine() {
        return Engine;
    }

    public void setEngine(String engine) {
        Engine = engine;
    }

    public String getTyre() {
        return Tyre;
    }

    public void setTyre(String tyre) {
        Tyre = tyre;
    }

    public String getBrake() {
        return Brake;
    }

    public void setBrake(String brake) {
        Brake = brake;
    }

    public String getSeat() {
        return Seat;
    }

    public void setSeat(String seat) {
        Seat = seat;
    }

    public String getWheel() {
        return Wheel;
    }

    public void setWheel(String wheel) {
        Wheel = wheel;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getHandles() {
        return Handles;
    }

    public void setHandles(String handles) {
        Handles = handles;
    }

    public String getMeterBoard() {
        return MeterBoard;
    }

    public void setMeterBoard(String meterBoard) {
        MeterBoard = meterBoard;
    }

    public String getLight() {
        return Light;
    }

    public void setLight(String light) {
        Light = light;
    }

    public String getExhaust() {
        return Exhaust;
    }

    public void setExhaust(String exhaust) {
        Exhaust = exhaust;
    }

    public String getAirFilter() {
        return AirFilter;
    }

    public void setAirFilter(String airFilter) {
        AirFilter = airFilter;
    }

    public String getDamage() {
        return Damage;
    }

    public void setDamage(String damage) {
        Damage = damage;
    }

    public String getBattery() {
        return Battery;
    }

    public void setBattery(String battery) {
        Battery = battery;
    }

    public String getMileage() {
        return Mileage;
    }

    public void setMileage(String mileage) {
        Mileage = mileage;
    }

    public String getKmDriven() {
        return KmDriven;
    }

    public void setKmDriven(String kmDriven) {
        KmDriven = kmDriven;
    }

    public String getGear() {
        return Gear;
    }

    public void setGear(String gear) {
        Gear = gear;
    }

    public String getShockAbsorber() {
        return ShockAbsorber;
    }

    public void setShockAbsorber(String shockAbsorber) {
        ShockAbsorber = shockAbsorber;
    }

    public String getModification() {
        return Modification;
    }

    public void setModification(String modification) {
        Modification = modification;
    }
}
