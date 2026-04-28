package com.riderrr.app.Controller;

import com.riderrr.app.Entity.Branch;
import com.riderrr.app.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
@CrossOrigin(origins = {"http://localhost:5173","http://127.0.0.1:5173"})
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping("/add")
    public ResponseEntity<Branch> addBranch(@RequestBody Branch branch){
        Branch b = branchService.addBranch(branch);
        return ResponseEntity.ok(b);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Branch>> getallBranches(){
        List<Branch> branch= branchService.getallBranches();
        return ResponseEntity.ok(branch);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBranch(@PathVariable Long id, @RequestBody Branch branch){
        Branch updatedBranch= branchService.updateBranch(id, branch);
        return ResponseEntity.ok(updatedBranch);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBranch(@PathVariable Long id){
        branchService.deletebranch(id);
    }

    @PostMapping("/find/{id}")
    public ResponseEntity<?> findbyid(@PathVariable Long id){

        return branchService.findbyid(id);
    }
}
