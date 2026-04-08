package com.riderrr.app.Controller.Website;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    @GetMapping("/api/bike")
    public String bike(){
        return "this /api/bike";
    }
}
