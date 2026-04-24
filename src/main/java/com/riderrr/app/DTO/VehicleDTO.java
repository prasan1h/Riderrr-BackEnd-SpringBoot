package com.riderrr.app.DTO;

import com.riderrr.app.Entity.Vehicle;
import com.riderrr.app.Entity.VehicleImage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleDTO {

    public VehicleResponse convertToDTO(Vehicle v) {

        VehicleResponse dto = new VehicleResponse();

        dto.setId(v.getId());
        dto.setBrand(v.getBrand());
        dto.setType(v.getType());
        dto.setModel(v.getModel());
        dto.setModelYear(v.getModelYear());
        dto.setColor(v.getColour());
        dto.setPurchaseDate(v.getPurchasedDate());
        dto.setPurchasedAmount(v.getPurchasedAmount());
        dto.setOwnerType(v.getOwnerType());
        dto.setRegistrationNumber(v.getRegisterNumber());
        List<String> imagePaths = new ArrayList<>();
        for (VehicleImage img : v.getImagePath()) {
            imagePaths.add(img.getFilePath());
        }
        dto.setImages(imagePaths);
        dto.setInspectionDate(v.getInspectionDate());
        dto.setInspectionBranch(v.getBranchId());
        dto.setCustomerName(v.getCustomerName());
        dto.setCustomerPhone(v.getCustomerPhNo());
        dto.setCustomerEmail(v.getCustomerEmail());
        dto.setStatus(v.getStatus());
        dto.setVisible(v.isVisible());
        dto.setSoldDate(v.getSoldDate());
        dto.setSellingPrice(v.getSellingPrice());
        dto.setAvailability(v.getAvailability());
        dto.setDocumentsGiven(v.isDocumentsGiven());

        return dto;
    }

    public VehicleResponse readDTO(Vehicle v) {

        VehicleResponse dto = new VehicleResponse();

        dto.setId(v.getId());
        dto.setBrand(v.getBrand());
        dto.setType(v.getType());
        dto.setModel(v.getModel());
        dto.setModelYear(v.getModelYear());
        dto.setColor(v.getColour());
        dto.setPurchaseDate(v.getPurchasedDate());
        dto.setPurchasedAmount(v.getPurchasedAmount());
        dto.setOwnerType(v.getOwnerType());
        dto.setRegistrationNumber(v.getRegisterNumber());
        List<String> imagePaths = new ArrayList<>();
        for (VehicleImage img : v.getImagePath()) {
            imagePaths.add(img.getFilePath());
        }
        dto.setImages(imagePaths);
        dto.setInspectionDate(v.getInspectionDate());
        dto.setInspectionBranch(v.getBranchId());
        dto.setCustomerName(v.getCustomerName());
        dto.setCustomerPhone(v.getCustomerPhNo());
        dto.setCustomerEmail(v.getCustomerEmail());
        dto.setStatus(v.getStatus());
        dto.setVisible(v.isVisible());
        dto.setSoldDate(v.getSoldDate());
        dto.setSellingPrice(v.getSellingPrice());
        dto.setAvailability(v.getAvailability());
        dto.setDocumentsGiven(v.isDocumentsGiven());

        return dto;
    }

}
