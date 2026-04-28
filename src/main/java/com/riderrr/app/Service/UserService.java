package com.riderrr.app.Service;

import com.riderrr.app.DTO.UserMapper;
import com.riderrr.app.DTO.UserRequestDTO;
import com.riderrr.app.DTO.UserResponseDTO;
import com.riderrr.app.Entity.Branch;
import com.riderrr.app.Entity.User;
import com.riderrr.app.Enum.Role;
import com.riderrr.app.ExceptionHandler.NotFoundException;
import com.riderrr.app.Repository.BranchRepository;
import com.riderrr.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BranchRepository branchRepository;

    public UserResponseDTO addUser(UserRequestDTO dto) {
        Branch branch = null;

        if (dto.getBranch() != null) {
            branch = branchRepository.findById(dto.getBranch())
                    .orElseThrow(() -> new NotFoundException("Branch not found"));
        }

        User user = UserMapper.toEntity(dto, branch);

        User savedUser = userRepository.save(user);

        return UserMapper.toDTO(savedUser);
    }

    public List<UserResponseDTO> getAllUsers(){

        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO dto){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        Branch branch = null;

        if (dto.getBranch() != null) {
            branch = branchRepository.findById(dto.getBranch())
                    .orElseThrow(() -> new NotFoundException("Branch not found"));
        }


        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
//        if (dto.getPassword() != null && !dto.getPassword().trim().isEmpty()) {
//            user.setPassword(dto.getPassword());
//        }
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setBranch(branch);
        user.setAddress(dto.getAddress());

        User updatedUser = userRepository.save(user);

        return UserMapper.toDTO(updatedUser);
    }


    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        userRepository.delete(user);
    }

    public UserResponseDTO findById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        return UserMapper.toDTO(user);
    }

    public List<UserResponseDTO> getUsersByBranch(Long branchId) {

        List<Role> roles = List.of(Role.STAFF, Role.MANAGER);

        List<User> users = userRepository.findByBranchIdAndRoleIn(branchId, roles);

        return users.stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    public List<User> getManagers() {
        return userRepository.findByRole(Role.MANAGER);
    }
}