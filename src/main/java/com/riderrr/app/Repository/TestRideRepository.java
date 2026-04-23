package com.riderrr.app.Repository;

import com.riderrr.app.Enum.TestRideStatus;
import com.riderrr.app.Entity.TestRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

    @Repository
    public interface TestRideRepository extends JpaRepository<TestRide, Long> {
        List<TestRide> findByStatus(TestRideStatus status);
        List<TestRide> findByBranch_IdAndStatus(Long branchId, TestRideStatus status);
    }

