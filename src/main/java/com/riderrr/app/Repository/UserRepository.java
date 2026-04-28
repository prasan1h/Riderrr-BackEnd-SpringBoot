package com.riderrr.app.Repository;

import com.riderrr.app.Entity.User;
import com.riderrr.app.Enum.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//    boolean existsByEmail(String email);
List<User> findByBranchIdAndRoleIn(Long branchId, List<Role> roles);

    List<User> findByRole(Role role);

}
