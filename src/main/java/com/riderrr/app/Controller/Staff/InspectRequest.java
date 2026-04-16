package com.riderrr.app.Controller.Staff;

import com.riderrr.app.DTO.VehicleResponse;
import com.riderrr.app.Enum.Status;
import com.riderrr.app.Service.Staff.InspectVehicle;
import com.riderrr.app.Service.Website.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5173/","http://localhost:5173"})
public class InspectRequest {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    InspectVehicle inspectVehicleService;

    @GetMapping("/api/bike/requestInspect")
    public List<VehicleResponse> all()
    {
        return vehicleService.all();
    }

    @PostMapping("/api/bike/requestInspect")
    public VehicleResponse acceptRequestInspect(
            @RequestParam Long id,
            @RequestParam Status status
    )
        throws IOException
    {
        return inspectVehicleService.update(
                id, status
        );
    }


}
