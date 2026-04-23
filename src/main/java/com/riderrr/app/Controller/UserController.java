package com.riderrr.app.Controller;

import com.riderrr.app.Entity.User;
import com.riderrr.app.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"http://localhost:5173","http://127.0.0.1:5173"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User user1= userService.addUser(user);
        return ResponseEntity.ok(user1);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> user= userService.getAllUsers();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/find/{id}")
    public ResponseEntity<?> findbyid(@PathVariable Long id){

        return userService.findbyid(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user){
        User updatedUser= userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}