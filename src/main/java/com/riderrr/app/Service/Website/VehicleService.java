package com.riderrr.app.Service.Website;

import com.riderrr.app.DTO.VehicleDTO;
import com.riderrr.app.DTO.VehicleResponse;
import com.riderrr.app.Entity.Vehicle;
import com.riderrr.app.Entity.VehicleImage;
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
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    VehicleDTO vehicleDTO;

    public VehicleResponse add(String brand, String type, String model, String modelYear, String color, LocalDate purchaseDate, Double purchasePrice, String ownerType, String registrationNumber, MultipartFile[] images, LocalDate inspectionDate, String inspectionBranch, String customerName, String customerPhone, String customerEmail)
            throws IOException
    {

        List<String> filePaths = fileUtil.saveFile(images);
        List<VehicleImage> imageList = new ArrayList<>();

        Vehicle v = new Vehicle();
        v.setBrand(brand);
        v.setType(type);
        v.setModel(model);
        v.setModelYear(Integer.parseInt(modelYear));
        v.setColour(color);
        v.setPurchasedDate(purchaseDate);
        v.setPurchasedAmount(purchasePrice);
        v.setOwnerType(ownerType);
        v.setRegisterNumber(registrationNumber);
//        v.setImagePath(filePath);
        v.setInspectionDate(inspectionDate);
        v.setCustomerName(customerName);
        v.setCustomerPhNo(customerPhone);
        v.setCustomerEmail(customerEmail);

        for (String path : filePaths) {
            VehicleImage img = new VehicleImage();
            img.setFilePath(path);
            img.setVehicle(v);        // VERY IMPORTANT (relationship)
            imageList.add(img);
        }

        v.setImagePath(imageList);

        Vehicle savedVehicle = vehicleRepository.save(v);
        return vehicleDTO.convertToDTO(savedVehicle);
    }
}
