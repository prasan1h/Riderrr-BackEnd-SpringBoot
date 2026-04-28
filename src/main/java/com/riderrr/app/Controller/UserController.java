package com.riderrr.app.Controller;

import com.riderrr.app.DTO.UserRequestDTO;
import com.riderrr.app.DTO.UserResponseDTO;
import com.riderrr.app.Entity.User;
import com.riderrr.app.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:5173","http://127.0.0.1:5173"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO dto){

        return ResponseEntity.ok(userService.addUser(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/find/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(userService.findById(id));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDTO dto){

        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){

        userService.deleteUser(id);

        return ResponseEntity.ok("User deleted successfully");
    }
}