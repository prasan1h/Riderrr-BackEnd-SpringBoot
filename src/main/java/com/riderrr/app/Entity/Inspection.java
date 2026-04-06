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
    private String inspectShockAbserver;
    private String inspectModification;
}
