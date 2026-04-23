package com.riderrr.app.Service.Staff;

import com.riderrr.app.DTO.VehicleDTO;
import com.riderrr.app.DTO.VehicleResponse;
import com.riderrr.app.Entity.Vehicle;
import com.riderrr.app.Entity.VehicleImage;
import com.riderrr.app.Enum.Status;
import com.riderrr.app.Repository.VehicleRepository;
import com.riderrr.app.Util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class InspectVehicle {
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    VehicleDTO vehicleDTO;

    public VehicleResponse update(Long id, String Availability)
            throws IOException
    {

        Vehicle v =  vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        v.setAvailability(Availability);


        Vehicle savedVehicle = vehicleRepository.save(v);
        return vehicleDTO.convertToDTO(savedVehicle);
    }

}
