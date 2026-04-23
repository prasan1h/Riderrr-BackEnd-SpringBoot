package com.riderrr.app.Service;

import com.riderrr.app.Entity.User;
import com.riderrr.app.ExceptionHandler.NotFoundException;
import com.riderrr.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());
        user.setBranch(updatedUser.getBranch());
        user.setAddress(updatedUser.getAddress());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }

    public ResponseEntity<?> findbyid(Long id) {
        User user= userRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found"));
        return ResponseEntity.ok(user);
    }
}