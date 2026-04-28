package com.riderrr.app.Service;

import com.riderrr.app.Entity.Branch;
import com.riderrr.app.ExceptionHandler.NotFoundException;
import com.riderrr.app.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;
    public List<Branch> getallBranches() {
        return branchRepository.findAll();
    }

    public Branch addBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public Branch updateBranch(Long id, Branch updatedBranch) {

        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        branch.setName(updatedBranch.getName());
        branch.setLocation(updatedBranch.getLocation());
        branch.setPhone(updatedBranch.getPhone());
        branch.setCity(updatedBranch.getCity());
        branch.setEmail(updatedBranch.getEmail());
        branch.setAddress(updatedBranch.getAddress());

        return branchRepository.save(branch);
    }

    public void deletebranch(Long id) {

        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("branch not found"));

        branchRepository.delete(branch);
    }


    public ResponseEntity<?> findbyid(Long id) {

            Branch b= branchRepository.findById(id).orElseThrow(()-> new NotFoundException("Branch not found"));
            return ResponseEntity.ok(b);
    }


}

