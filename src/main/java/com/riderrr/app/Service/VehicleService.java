package com.riderrr.app.Service;

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
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    VehicleDTO vehicleDTO;

    public VehicleResponse add(String brand, String type, String model, String modelYear, String color, LocalDate purchaseDate, Double PurchasedAmount, String ownerType, String registrationNumber, MultipartFile[] images, LocalDate inspectionDate, String inspectionBranch, String customerName, String customerPhone, String customerEmail)
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
        v.setPurchasedAmount(PurchasedAmount);
        v.setOwnerType(ownerType);
        v.setRegisterNumber(registrationNumber);
        v.setInspectionDate(inspectionDate);
        v.setCustomerName(customerName);
        v.setCustomerPhNo(customerPhone);
        v.setCustomerEmail(customerEmail);

        for (String path : filePaths) {
            VehicleImage img = new VehicleImage();
            img.setFilePath(path);
            img.setVehicle(v);
            imageList.add(img);
        }

        v.setImagePath(imageList);

        Vehicle savedVehicle = vehicleRepository.save(v);
        return vehicleDTO.convertToDTO(savedVehicle);
    }

    public List<VehicleResponse> all() {
        List<Vehicle> vehicles = vehicleRepository.findAll();

        List<VehicleResponse> fetchAll = new ArrayList<>();

        for (Vehicle v : vehicles) {
            fetchAll.add(vehicleDTO.readDTO(v)); // single mapping
        }

        return fetchAll;
    }

    public VehicleResponse updateVehicleStatus(Long id, Status status)
            throws IOException
    {
        Vehicle v =  vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        v.setStatus(status);

        Vehicle savedVehicle = vehicleRepository.save(v);
        return vehicleDTO.convertToDTO(savedVehicle);
    }

    public VehicleResponse updateVehicleVisibility(Long id, Boolean isVisible)
            throws IOException
    {
        Vehicle v =  vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        v.setVisible(isVisible);

        Vehicle savedVehicle = vehicleRepository.save(v);
        return vehicleDTO.convertToDTO(savedVehicle);
    }

    public VehicleResponse updateVehicleAvailability(Long id, String Availability)
            throws IOException
    {
        Vehicle v =  vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        v.setAvailability(Availability);

        Vehicle savedVehicle = vehicleRepository.save(v);
        return vehicleDTO.convertToDTO(savedVehicle);
    }


    public VehicleResponse updateVehicleByManager(
            Long id, double outLetPrice, Boolean isVisible, int Mileage, MultipartFile[] images
    )
            throws IOException
    {
        Vehicle v =  vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));

        List<String> filePaths = fileUtil.saveFile(images);
//        List<VehicleImage> imageList = new ArrayList<>();

        v.setVisible(isVisible);
        v.setMileage(Mileage);
        v.setOutLetPrice(outLetPrice);

        for (VehicleImage img : v.getImagePath()) {
            fileUtil.deleteFile(img.getFilePath());
        }
        v.getImagePath().clear();

        for (String path : filePaths) {
            VehicleImage img = new VehicleImage();
            img.setFilePath(path);
            img.setVehicle(v);
            v.getImagePath().add(img);
        }


        Vehicle savedVehicle = vehicleRepository.save(v);
        return vehicleDTO.convertToDTO(savedVehicle);
    }

    public VehicleResponse soldDetailsUpdate(Long id, String availability, LocalDate soldDate, double sellingPrice, String customerName, String customerPhone, boolean documentsGiven)
            throws IOException
    {
        Vehicle v =  vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));

        v.setAvailability(availability);
        v.setSoldDate(soldDate);
        v.setSellingPrice(sellingPrice);
        v.setCustomerName(customerName);
        v.setCustomerPhNo(customerPhone);
        v.setDocumentsGiven(documentsGiven);

        Vehicle savedVehicle = vehicleRepository.save(v);
        return vehicleDTO.convertToDTO(savedVehicle);
    }

    public VehicleResponse editVehicleDetails(
            Long id, String brand, String type, String model, String modelYear, String color, LocalDate purchaseDate, Double PurchasedAmount, String ownerType, String registrationNumber, LocalDate inspectionDate, String inspectionBranch, Boolean isVisible, int mileage, double outLetPrice
    )
            throws IOException
    {
        Vehicle v =  vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));

        v.setBrand(brand);
        v.setType(type);
        v.setModel(model);
        v.setModelYear(Integer.parseInt(modelYear));
        v.setColour(color);
        v.setPurchasedDate(purchaseDate);
        v.setPurchasedAmount(PurchasedAmount);
        v.setOwnerType(ownerType);
        v.setRegisterNumber(registrationNumber);
        v.setInspectionDate(inspectionDate);
        v.setVisible(isVisible);
        v.setMileage(mileage);
        v.setOutLetPrice(outLetPrice);


        Vehicle savedVehicle = vehicleRepository.save(v);
        return vehicleDTO.convertToDTO(savedVehicle);
    }
}
