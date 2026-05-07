package com.riderrr.app.Repository;

import com.riderrr.app.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {

    @Query("SELECT b FROM Branch b WHERE " +
            "LOWER(COALESCE(b.name, '')) LIKE CONCAT('%', LOWER(:keyword), '%') OR " +
            "LOWER(COALESCE(b.email, '')) LIKE CONCAT('%', LOWER(:keyword), '%') OR " +
            "LOWER(COALESCE(b.location, '')) LIKE CONCAT('%', LOWER(:keyword), '%') OR " +
            "LOWER(COALESCE(b.city, '')) LIKE CONCAT('%', LOWER(:keyword), '%') OR " +
            "LOWER(COALESCE(b.phone, '')) LIKE CONCAT('%', LOWER(:keyword), '%')")
    List<Branch> search(@Param("keyword") String keyword);
}
