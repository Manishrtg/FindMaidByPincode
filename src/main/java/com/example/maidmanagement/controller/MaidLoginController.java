package com.example.maidmanagement.controller;

import com.example.maidmanagement.dto.MaidLoginDTO;
import com.example.maidmanagement.model.Maid;
import com.example.maidmanagement.service.MaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maid")
public class MaidLoginController {

    @Autowired
    private MaidService maidService;

    // Login endpoint for the Maid
    @PostMapping("/login")
    public ResponseEntity<MaidLoginDTO> loginMaid(@RequestBody MaidLoginDTO.LoginRequest loginRequest) {
        Maid maid = maidService.authenticateMaid(loginRequest.getUsername(), loginRequest.getPassword());

        if (maid != null) {
            MaidLoginDTO.LoginResponse loginResponse = new MaidLoginDTO.LoginResponse("Login successful");
            MaidLoginDTO response = new MaidLoginDTO(loginResponse);
            return ResponseEntity.ok(response); // Successful login
        } else {
            MaidLoginDTO.LoginResponse loginResponse = new MaidLoginDTO.LoginResponse("Invalid username or password");
            MaidLoginDTO response = new MaidLoginDTO(loginResponse);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // Unauthorized
        }
    }
}
