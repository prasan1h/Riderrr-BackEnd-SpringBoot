package com.riderrr.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inspectId;

    private Long V_id;
    private Long E_id;
    private String inspectEngine;
    private String inspectTyre;
    private String inspectBrake;
    private String inspectSeat;
    private String inspectWheel;
    private String inspectBody;
    private String inspectHandles;
    private String inspectMeterBoard;
    private String inspectLight;
    private String inspectExhaust;
    private String inspectAirFilter;
    private String inspectDamage;
    private String inspectBattery;
    private String inspectMileage;
    private String inspectKmDriven;
    private String inspectGear;
    private String inspectShockAbsorber;
    private String inspectModification;

    public Inspection(Long inspectId, Long v_id, Long e_id, String inspectEngine, String inspectTyre, String inspectBrake, String inspectSeat, String inspectWheel, String inspectBody, String inspectHandles, String inspectMeterBoard, String inspectLight, String inspectExhaust, String inspectAirFilter, String inspectDamage, String inspectBattery, String inspectMileage, String inspectKmDriven, String inspectGear, String inspectShockAbsorber, String inspectModification) {
        this.inspectId = inspectId;
        V_id = v_id;
        E_id = e_id;
        this.inspectEngine = inspectEngine;
        this.inspectTyre = inspectTyre;
        this.inspectBrake = inspectBrake;
        this.inspectSeat = inspectSeat;
        this.inspectWheel = inspectWheel;
        this.inspectBody = inspectBody;
        this.inspectHandles = inspectHandles;
        this.inspectMeterBoard = inspectMeterBoard;
        this.inspectLight = inspectLight;
        this.inspectExhaust = inspectExhaust;
        this.inspectAirFilter = inspectAirFilter;
        this.inspectDamage = inspectDamage;
        this.inspectBattery = inspectBattery;
        this.inspectMileage = inspectMileage;
        this.inspectKmDriven = inspectKmDriven;
        this.inspectGear = inspectGear;
        this.inspectShockAbsorber = inspectShockAbsorber;
        this.inspectModification = inspectModification;
    }

    public Long getInspectId() {
        return inspectId;
    }

    public void setInspectId(Long inspectId) {
        this.inspectId = inspectId;
    }

    public Long getV_id() {
        return V_id;
    }

    public void setV_id(Long v_id) {
        V_id = v_id;
    }

    public Long getE_id() {
        return E_id;
    }

    public void setE_id(Long e_id) {
        E_id = e_id;
    }

    public String getInspectEngine() {
        return inspectEngine;
    }

    public void setInspectEngine(String inspectEngine) {
        this.inspectEngine = inspectEngine;
    }

    public String getInspectTyre() {
        return inspectTyre;
    }

    public void setInspectTyre(String inspectTyre) {
        this.inspectTyre = inspectTyre;
    }

    public String getInspectBrake() {
        return inspectBrake;
    }

    public void setInspectBrake(String inspectBrake) {
        this.inspectBrake = inspectBrake;
    }

    public String getInspectSeat() {
        return inspectSeat;
    }

    public void setInspectSeat(String inspectSeat) {
        this.inspectSeat = inspectSeat;
    }

    public String getInspectWheel() {
        return inspectWheel;
    }

    public void setInspectWheel(String inspectWheel) {
        this.inspectWheel = inspectWheel;
    }

    public String getInspectBody() {
        return inspectBody;
    }

    public void setInspectBody(String inspectBody) {
        this.inspectBody = inspectBody;
    }

    public String getInspectHandles() {
        return inspectHandles;
    }

    public void setInspectHandles(String inspectHandles) {
        this.inspectHandles = inspectHandles;
    }

    public String getInspectMeterBoard() {
        return inspectMeterBoard;
    }

    public void setInspectMeterBoard(String inspectMeterBoard) {
        this.inspectMeterBoard = inspectMeterBoard;
    }

    public String getInspectLight() {
        return inspectLight;
    }

    public void setInspectLight(String inspectLight) {
        this.inspectLight = inspectLight;
    }

    public String getInspectExhaust() {
        return inspectExhaust;
    }

    public void setInspectExhaust(String inspectExhaust) {
        this.inspectExhaust = inspectExhaust;
    }

    public String getInspectAirFilter() {
        return inspectAirFilter;
    }

    public void setInspectAirFilter(String inspectAirFilter) {
        this.inspectAirFilter = inspectAirFilter;
    }

    public String getInspectDamage() {
        return inspectDamage;
    }

    public void setInspectDamage(String inspectDamage) {
        this.inspectDamage = inspectDamage;
    }

    public String getInspectBattery() {
        return inspectBattery;
    }

    public void setInspectBattery(String inspectBattery) {
        this.inspectBattery = inspectBattery;
    }

    public String getInspectMileage() {
        return inspectMileage;
    }

    public void setInspectMileage(String inspectMileage) {
        this.inspectMileage = inspectMileage;
    }

    public String getInspectKmDriven() {
        return inspectKmDriven;
    }

    public void setInspectKmDriven(String inspectKmDriven) {
        this.inspectKmDriven = inspectKmDriven;
    }

    public String getInspectGear() {
        return inspectGear;
    }

    public void setInspectGear(String inspectGear) {
        this.inspectGear = inspectGear;
    }

    public String getInspectShockAbsorber() {
        return inspectShockAbsorber;
    }

    public void setInspectShockAbsorber(String inspectShockAbsorber) {
        this.inspectShockAbsorber = inspectShockAbsorber;
    }

    public String getInspectModification() {
        return inspectModification;
    }

    public void setInspectModification(String inspectModification) {
        this.inspectModification = inspectModification;
    }
}
