package com.riderrr.app.Service;

import com.riderrr.app.Enum.Status;
import com.riderrr.app.Entity.Inspection;
import com.riderrr.app.Entity.Vehicle;
import com.riderrr.app.Repository.InspectionRepository;
import com.riderrr.app.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

    @Service
    public class InspectionService {

        @Autowired
        private InspectionRepository inspectionRepository;

        @Autowired
        private VehicleRepository vehicleRepository;

        public List<Inspection> getInspectionsByVehicleStatus(Status status) {
            return inspectionRepository.findByVehicleId_Status(status);
        }

        public Inspection getInspectionByVehicleId(Long vehicleId) {
            return inspectionRepository.findByVehicleId_Id(vehicleId)
                    .orElseThrow(() -> new RuntimeException("Inspection report not found"));
        }

        @Transactional
        public Inspection saveInspectionAsDraft(Long vehicleId, Inspection inspectionData) {
            return processInspection(vehicleId, inspectionData, Status.DRAFT);
        }

        @Transactional
        public Inspection submitInspection(Long vehicleId, Inspection inspectionData) {
            return processInspection(vehicleId, inspectionData, Status.APPROVED);
        }



        private Inspection processInspection(Long vehicleId, Inspection inspectionData, Status newStatus) {
            Vehicle vehicle = vehicleRepository.findById(vehicleId)
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));

            Inspection inspection = inspectionRepository.findByVehicleId_Id(vehicleId).orElse(new Inspection());

            inspection.setVehicleId(vehicle);
            inspection.setEngine(inspectionData.getEngine());
            inspection.setTyre(inspectionData.getTyre());
            inspection.setBrake(inspectionData.getBrake());
            inspection.setSeat(inspectionData.getSeat());
            // Map other fields here...
            inspection.setMileage(inspectionData.getMileage());

            vehicle.setStatus(newStatus);
            vehicleRepository.save(vehicle);
            return inspectionRepository.save(inspection);
        }

        @Transactional
        public void acceptAndPublish(Long vehicleId, double outletPrice, int mileage) {
            Vehicle vehicle = vehicleRepository.findById(vehicleId)
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));

            vehicle.setOutLetPrice(outletPrice);
            vehicle.setMileage(mileage);
            vehicle.setVisible(true);
            vehicle.setStatus(Status.ACCEPTED);
            vehicleRepository.save(vehicle);
        }
    }

