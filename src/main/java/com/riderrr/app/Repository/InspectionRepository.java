package com.riderrr.app.Repository;

import com.riderrr.app.Enum.Status;
import com.riderrr.app.Entity.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

    @Repository
    public interface InspectionRepository extends JpaRepository<Inspection, Long> {
        List<Inspection> findByVehicleId_Status(Status status);
        Optional<Inspection> findByVehicleId_Id(Long vehicleId);
    }

