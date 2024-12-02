package com.example.maidmanagement.controller;

import com.example.maidmanagement.dto.OwnerLoginDTO;
import com.example.maidmanagement.model.Owner;
import com.example.maidmanagement.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class OwnerLoginController {

    @Autowired
    private OwnerService ownerService;

    // POST endpoint for owner login
    @PostMapping("/login")
    public ResponseEntity<OwnerLoginDTO> loginOwner(@RequestBody OwnerLoginDTO.LoginRequest loginRequest) {
        Owner owner = ownerService.authenticateOwner(loginRequest.getUsername(), loginRequest.getPassword());

        if (owner != null) {
            // Successful login
            OwnerLoginDTO.LoginResponse loginResponse = new OwnerLoginDTO.LoginResponse("Login successful");
            OwnerLoginDTO response = new OwnerLoginDTO(loginResponse);
            return ResponseEntity.ok(response);
        } else {
            // Unauthorized login attempt
            OwnerLoginDTO.LoginResponse loginResponse = new OwnerLoginDTO.LoginResponse("Invalid username or password");
            OwnerLoginDTO response = new OwnerLoginDTO(loginResponse);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}
