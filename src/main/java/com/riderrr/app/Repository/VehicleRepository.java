package com.riderrr.app.Repository;

import com.riderrr.app.Entity.Vehicle;
import com.riderrr.app.Enum.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Long>, JpaSpecificationExecutor<Vehicle> {

    @Query("SELECT v FROM Vehicle v WHERE v.status = :status")
    List<Vehicle> findVehiclesByStatus(@Param("status") Status status);


    @Query("SELECT v FROM Vehicle v WHERE v.status = 'ACCEPTED' AND v.isVisible = true AND v.availability = 'AVAILABLE'")
    List<Vehicle> findAcceptedVisibleAvailableVehicles();

    @Query("SELECT v FROM Vehicle v WHERE v.status = 'ACCEPTED' AND v.isVisible = true AND v.availability = 'AVAILABLE'")
    List<Vehicle> findRecent(Pageable pageable);

}
